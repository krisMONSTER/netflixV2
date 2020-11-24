import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

//import com.google.gson.JsonElement; komentarze krysi
//import com.google.gson.JsonParser;

public class filmyWideo {
    private static ArrayList<String> genresList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
/* komentarz krysi
        // PLIKI I ZAINICJOWANIE JE SKRYPTEM
        FileWriter sqlFile = new FileWriter("bazavideo.txt",true);
        FileWriter sqlFile2 = new FileWriter("bazagenres.txt",true);
        //sqlFile.write("DELETE FROM video;\nINSERT INTO video (title, idCAT, cost, description, endDate)\n" +"VALUES\n");
        //sqlFile2.write("DELETE FROM category;\nINSERT INTO category (name)\n" +"VALUES\n");


        String host = "http://www.omdbapi.com/";
        String api_key= "b26fd8d0";



        HttpResponse<JsonNode> response;
        JsonParser jp = new JsonParser();
        //long temp=3896198; // 1 dzien+973
        //long temp = 3897171; // 2gi dzien+1000
        //long temp=3898171; // 3ci dzien +1000
        //long temp = 3899171; //4ty dzien +1000
        //long temp = 3901171; //5ty dzien +1000
        //long temp = 3902171+885//6ty dzien +885;
        long temp =2713423;
        int i=0;
        do{
            response=Unirest.get(host).queryString("i", "tt"+temp).queryString("apikey", api_key).asJson();
            JsonElement je = jp.parse(response.getBody().toString());
            //System.out.println(je);
            if(je.getAsJsonObject().get("Response").getAsBoolean()&&je.getAsJsonObject().get("Type").getAsString().equals("movie")&&!je.getAsJsonObject().get("Genre").getAsString().equals("N/A")&&!je.getAsJsonObject().get("Plot").getAsString().equals("N/A")) {
                String title = je.getAsJsonObject().get("Title").getAsString();
                //zamieniam bo sie potem baza pruje jak np jest Adam's cat xd
                String description = je.getAsJsonObject().get("Plot").getAsString().replaceAll("'", "");
                String genre = je.getAsJsonObject().get("Genre").getAsString();
                writeMovie(sqlFile, title, genre, description);
                writeGenre(sqlFile2, genre);
                System.out.println(i);
                System.out.println(je);
                i++;
                temp++;

            }
            else{
                System.out.println(i);
                System.out.println(je);
                i++;
                temp++;

                continue;
            }

        }while(i<1000);

 */







/*
        response = Unirest.get(host).queryString("i", "tt3896174").queryString("apikey", api_key).asJson();
        je = jp.parse(response.getBody().toString());
        title = je.getAsJsonObject().get("Title").getAsString();
        description = je.getAsJsonObject().get("Plot").getAsString().replaceAll("'","");
        genre = je.getAsJsonObject().get("Genre").getAsString();


       writeMovie(sqlFile,title,genre,description);
        writeGenre(sqlFile2,genre);
*/
/* komentarz krysi
        sqlFile.close();
        sqlFile2.close();
        //  id  TITLE   idCAT   COST=10 DESCRIPTION     endDate=costam  status

 */
    }

    private static void writeMovie(FileWriter file, String title, String genresString, String description) throws  Exception{
        String[] genres = genresString.replaceAll("\\s+", "").split("[,]",0);
        for(String genre:genres){
            file.write("('"+title+"', (SELECT id FROM category WHERE name = '"+genre+"'), "+10+", '"+description+"', NOW()),"+"\n");
        }

    }

    private static void writeGenre(FileWriter file, String genresString) throws  Exception{

        String[] genres = genresString.replaceAll("\\s+", "").split("[,]",0);

        for (String genre:genres) {
            if (!genresList.contains(genre)) {
                genresList.add(genre);
                file.write("('" + genre + "')," + "\n");
            }
            else
                continue;
        }

    }
}
