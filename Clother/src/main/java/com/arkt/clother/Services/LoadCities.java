package com.arkt.clother.Services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class LoadCities {

    private List<String> lstCities;

    public LoadCities() {
        lstCities = new ArrayList<>();
        try {

            ClassPathResource resource = new ClassPathResource("city_list.gz");
            InputStream inputStream = resource.getInputStream();
            StringBuilder builder = new StringBuilder();
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);

            InputStreamReader reader = new InputStreamReader(gzipInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String readed;
            while ((readed = bufferedReader.readLine()) != null)
                builder.append(readed);
            lstCities = new Gson().fromJson(builder.toString(), new TypeToken<List<String>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLstCities() {
        return lstCities;
    }
}
