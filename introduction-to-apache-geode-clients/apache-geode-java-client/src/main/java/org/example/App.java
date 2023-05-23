package org.example;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

public class App {
    public static void main(String[] args) {
        ClientCache cache = new ClientCacheFactory().addPoolLocator("127.0.0.1", 10334).create();

        Region<String, String> helloWorldRegion = cache.<String, String>createClientRegionFactory(ClientRegionShortcut.PROXY)
                .create("helloWorld");

        // Simple Put with Apache Geode Java Client
        helloWorldRegion.put("1", "HelloWorldValue");
        // Simple Get with Apache Geode Java Client
        String value1 = helloWorldRegion.get("1");
        System.out.println(value1);

        cache.close();

    }
}
