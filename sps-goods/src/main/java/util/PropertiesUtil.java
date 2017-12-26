package util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


@Component
public class PropertiesUtil {

    private static final Log log = LogFactory.getLog(PropertiesUtil.class);
    private Map map = new HashMap();
    private String webInfPath = null;
    private List<ClassPathResource> locations;

    public PropertiesUtil() {

    }

    public void init() {
        this.webInfPath = System.getProperty("FFP.WEB.ROOT");
    }

    public void initMap() {
        for (ClassPathResource location : locations) {
            try {
                Properties properties = new Properties();
                properties.load(location.getInputStream());
                this.map.putAll(properties);
            } catch (Exception ex) {
                System.out.println("fileName: " + location + " has some errors");
                ex.printStackTrace();
            }
        }
    }

    public String getWebInfPath() {
        return webInfPath;
    }

    public String get(String key) {
        Object obj = this.map.get(key);
        if (obj == null)
            return null;
        return obj.toString();
    }

    public String get(String key,String defaultValue) {
        Object obj = map.get(key);
        if (obj == null)
            return defaultValue;
        return obj.toString();
    }

    public List<ClassPathResource> getLocations() {
        return locations;
    }

    public void setLocations(List<ClassPathResource> locations) {
        this.locations = locations;
        this.initMap();
//        this.init();
    }
}