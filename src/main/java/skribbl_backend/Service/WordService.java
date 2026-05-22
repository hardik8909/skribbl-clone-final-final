package skribbl_backend.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordService {

    private final List<String> words = new ArrayList<>();

    public WordService() {

        try {

            BufferedReader reader =
                    new BufferedReader(

                            new InputStreamReader(
                                    getClass()
                                            .getResourceAsStream(
                                                    "/words.txt"
                                            )
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                words.add(line);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String getRandomWord() {

        Random random = new Random();

        return words.get(
                random.nextInt(words.size())
        );
    }
    public String maskWord(String word) {

        return word.replaceAll(".", "_ ");
    }
}