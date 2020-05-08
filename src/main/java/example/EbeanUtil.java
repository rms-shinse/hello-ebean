package example;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.ebean.Database;
import io.ebean.Model;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import org.reflections.Reflections;

import java.util.Set;

public class EbeanUtil {
  public static class DatabaseFactory {
    static final String PLAY_CONFIG_KEY_DB_USER = "db.%s.username";
    static final String PLAY_CONFIG_KEY_DB_PASS = "db.%s.password";
    static final String PLAY_CONFIG_KEY_DB_URL = "db.%s.url";
    static final String PLAY_CONFIG_KEY_DB_DRIVER = "db.%s.driver";

    public static Database create(String dbName) {
      final Config appConfig = ConfigFactory.load();
      final DataSourceConfig dataSourceConfig = createEBeanConfigByName(appConfig, dbName);
      final DatabaseConfig dbConfig = new DatabaseConfig();

      dbConfig.setDataSourceConfig(dataSourceConfig);

      final String modelPackageName = "example.models";
      Set<Class<? extends Model>> clases =  new Reflections(modelPackageName)
              .getSubTypesOf(Model.class);
      for (Class<? extends Model> c : clases) {
        dbConfig.addClass(c);
      }

      return io.ebean.DatabaseFactory.create(dbConfig);
    }

    private static DataSourceConfig createEBeanConfigByName(Config appConfig, String dbName) {
      final String dbUserKey = String.format(PLAY_CONFIG_KEY_DB_USER, dbName);
      final String dbPassKey = String.format(PLAY_CONFIG_KEY_DB_PASS, dbName);
      final String dbUrlKey = String.format(PLAY_CONFIG_KEY_DB_URL, dbName);
      final String dbDriverKey = String.format(PLAY_CONFIG_KEY_DB_DRIVER, dbName);

      final DataSourceConfig dataSourceConfig = new DataSourceConfig();
      dataSourceConfig.setUsername(appConfig.getString(dbUserKey));
      dataSourceConfig.setPassword(appConfig.getString(dbPassKey));
      dataSourceConfig.setUrl(appConfig.getString(dbUrlKey));
      dataSourceConfig.setDriver(appConfig.getString(dbDriverKey));

      return dataSourceConfig;
    }
  }
}
