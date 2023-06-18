package javatask.task15_plant_shop_materils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


class MyEx1 {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}







//        try {
//            InputStream inputStream = JSONex.class.getResourceAsStream("C:\\Users\\Slonick\\IdeaProjects\\javaProCourse\\src\\main\\resources\\ex.json");
//            assert inputStream != null;
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//            JSONObject json = new JSONObject(stringBuilder.toString());
//            Map<String, Object> map = json.toMap();
//
//            for (String key : map.keySet()) {
//                System.out.println(key + " : " + map.get(key));
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error reading or parsing JSON: " + e.getMessage());
//        }
