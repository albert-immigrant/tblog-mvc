package com.tangzq;

import com.tangzq.model.User_me;
import com.tangzq.repository.UserRepository;

import java.util.Random;

public class UserNameDb {
    public String[] boyNames =new String[]{
            "Noah","Liam","Jacob", "Mason", "William", "Ethan",
            "Michael","Alexander","James","Elijah","Daniel",
            "Benjamin","Aiden","Jayden","Logan","Matthew",
            "David","Joseph","Lucas","Jackson","Anthony",
            "Joshua","Samuel","Andrew", "Gabriel","Christopher",
            "John","Dylan","Carter","Isaac","Ryan","Luke",
            "Oliver","Nathan","Henry","Owen","Caleb",
            "Wyatt","Christian","Sebastian","Jack","Jonathan",
            "Landon","Julian","Isaiah", "Hunter","Levi",
            "Aaron","Eli","Charles","Thomas","Connor",
            "Brayden","Nicholas","Jaxon","Jeremiah","Cameron","Evan",
            "Adrian","Jordan","Gavin","Grayson","Angel",
            "Robert","Tyler","Josiah","Austin","Colton",
            "Brandon","Jose","Dominic","Kevin","Zachary",
            "Ian","Chase","Jason","Adam","Ayden",
            "Parker","Hudson","Cooper","Nolan","Lincoln",
            "Xavier","Carson","Jace","Justin","Easton",
            "Mateo","Asher","Bentley","Blake","Nathaniel",
            "Jaxson","Leo","Kayden","Tristan","Luis",
            "Elias",
            "Brody",
            "Bryson",
            "Juan",
            "Vincent",
            "Cole",
            "Micah",
            "Ryder",
            "Theodore",
            "Carlos",
            "Ezra",
            "Damian",
            "Miles",
            "Santiago",
            "Max",
            "Jesus",
            "Leonardo",
            "Sawyer",
            "Diego",
            "Alex",
            "Roman",
            "Maxwell",
            "Eric",
            "Greyson",
            "Hayden",
            "Giovanni",
            "Wesley",
            "Axel",
            "Camden",
            "Braxton",
            "Ivan",
            "Ashton",
            "Declan",
            "Bryce",
            "Timothy",
            "Antonio",
            "Silas",
            "Kaiden",
            "Ezekiel",
            "Jonah",
            "Weston",
            "George",
            "Harrison",
            "Steven",
            "Miguel",
            "Richard",
            "Bryan",
            "Kaleb",
            "Victor",
            "Aidan",
            "Jameson",
            "Joel",
            "Patrick",
            "Jaden",
            "Colin",
            "Everett",
            "Preston",
            "Maddox",
            "Edward",
            "Alejandro",
            "Kaden",
            "Jesse",
            "Emmanuel",
            "Kyle",
            "Brian",
            "Emmett",
            "Jude",
            "Marcus",
            "Kingston",
            "Kai",
            "Alan",
            "Malachi",
            "Grant",
            "Jeremy",
            "Riley",
            "Jayce",
            "Bennett",
            "Abel",
            "Ryker",
            "Caden",
            "Brantley",
            "Luca",
            "Brady",
            "Calvin",
            "Sean",
            "Oscar",
            "Jake",
            "Maverick",
            "Abraham",
            "Mark",
            "Tucker",
            "Nicolas",
            "Bradley",
            "Kenneth",
            "Avery",
            "Cayden",
            "King",
            "Paul",
            "Amir",
            "Gael",
            "Graham",
            "Maximus"
    };
    private UserRepository userRepository;
    public UserNameDb(){ }
    public UserNameDb(UserRepository repository){
        this.userRepository=repository;
    }

    public void generateFakeUser(){
        UserNameDb userNameDb = new UserNameDb();
        User_me user_a ;
        int length_w = userNameDb.boyNames.length;
        Random rr = new Random();
        {
            int name_0 = rr.nextInt(length_w);
            user_a = new User_me();
            String uName = userNameDb.boyNames[name_0].toLowerCase();
            int min = 97;
            int max = 122;
            String sufix_a = "";
            for (int i = 0; i < 3; i++) {
                int ran1 = (int) (Math.random() * (122 - 97) + 97);
                sufix_a += (char) ran1;
            }
            uName +="_"+ sufix_a;
            user_a.setUsername(uName);
            user_a.setEmail(uName + "@admin");
            user_a.setAvatarUrl("http://" + uName + ".cc");
            user_a.setWebsite("http://" + uName + ".cc");
            user_a.setPassword("123456");
            user_a.setIsactive(true);
           /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //sdf.format("2020-11-31 05:11:15");
            try {
                user_a.setDateCreated(sdf.parse("2020-11-25 15:11:15").toString());
            }catch (Exception e){}
            */
            user_a.setDateCreated("2020-11-25 15:11:15");
            user_a.setAvatarURLUploaded(true);
            user_a.setSelfDesc("here is "+uName);
            userRepository.save(user_a);
        }

    }
}
