package com.example.onthivnu_ept;

public class InitiateDataBase {
    public InitiateDataBase() {
    }
    public void start(DataBaseHelper dbHelper){
        //ID_infor = 1, part = 2, type = Listening
        //Information
        dbHelper.addInfor(1, 0,  R.raw.id1_part2, "");
        //Questions
        dbHelper.addQuestion("The topic of the radio program probably is _____.",
                "Never think about past mistakes",
                "How to be optimistic",
                "Be positive in failures",
                "Always use positive language",
                "B",
                "Listening",
                1,
                2);
        dbHelper.addQuestion("For Andy, _____ is very important",
                "living for today",
                "keeping past memories",
                "arranging for the future",
                "avoiding mistakes",
                "A",
                "Listening",
                1,
                2);
        dbHelper.addQuestion("Julie says people have negative thoughts _____. ",
                " if they fail in love",
                "every time they fail ",
                "now and then",
                "when they stop working",
                "C",
                "Listening",
                1,
                2);
        dbHelper.addQuestion("Julie probably tells herself “_____” if she learns to ride a bicycle.",
                "It will take me too much time.",
                "I’ll fail again.",
                "I’ll never try again if I fail now.",
                "I can ride it soon.",
                "D",
                "Listening",
                1,
                2);
        dbHelper.addQuestion("Miriam says that we should _____ to improve our bad feelings.  ",
                "do good things to other people",
                " list all the things for a good future",
                "keep a list of good memories at hand ",
                "try to have a good time every week",
                "C",
                "Listening",
                1,
                2);
        dbHelper.addQuestion("Michael doesn’t want to say “I’m sorry” because he thinks _____. ",
                "it’s not good to admit a mistake",
                "action is more important than words",
                "it’s better to say “I know my mistake” ",
                "positive language can encourage people better",
                "D",
                "Listening",
                1,
                2);
        //part = 1, type = Listening
        //Information
        dbHelper.addInfor(2, 0, R.raw.id2_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "At a romantic restaurant. ",
                "In a law company.",
                "At Tom’s house",
                "At a movie theater",
                "D",
                "Listening",
                2,
                1);
        //Information
        dbHelper.addInfor(3, 0, R.raw.id3_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "In cash.",
                "By debit card.",
                "By credit card.",
                "By check.",
                "C",
                "Listening",
                3,
                1);
        //Information
        dbHelper.addInfor(4, 0, R.raw.id4_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "Buy some birthday cards.",
                "Send some postcards.",
                "Send some gifts to his six relatives.",
                "Send some birthday cards to Peru.",
                "B",
                "Listening",
                4,
                1);
        //Information
        dbHelper.addInfor(5, 0, R.raw.id5_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "Japan.",
                "The U.S.",
                "Kuwait.",
                " Austria.",
                "A",
                "Listening",
                5,
                1);
        //Information
        dbHelper.addInfor(6, 0, R.raw.id6_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "They are worried, so they cannot eat.",
                "They do not have enough time.",
                "They are working.",
                " They will leave work in ten minutes.",
                "B",
                "Listening",
                6,
                1);
        //Information
        dbHelper.addInfor(7, 0, R.raw.id7_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "$29.",
                "Nearly $30",
                "$39.99.",
                "$20.99.",
                "B",
                "Listening",
                7,
                1);
        //Information
        dbHelper.addInfor(8, 0, R.raw.id8_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "Interested.",
                "Disappointed.",
                "Annoyed.",
                "Angry.",
                "C",
                "Listening",
                8,
                1);
        //Information
        dbHelper.addInfor(9, 0, R.raw.id9_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "The customer may be inexperienced.",
                "The customer sends e-mail too often.",
                "The customer has an important business e-mail.",
                "He (the technician) knows what the problem is.",
                "A",
                "Listening",
                9,
                1);
        //Information
        dbHelper.addInfor(10, 0, R.raw.id10_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "Australia.",
                "Ireland.",
                "Scotland.",
                "America",
                "D",
                "Listening",
                10,
                1);
        //Information
        dbHelper.addInfor(11, 0, R.raw.id11_part1, "");
        //Questions
        dbHelper.addQuestion("",
                "It was expensive.",
                "It was cheaper.",
                "It was his girlfriend’s choice",
                "It was more interesting than the trip to Japan.",
                "B",
                "Listening",
                11,
                1);
        //ID_infor = 12, part = 3, type = Listening
        //Information
        dbHelper.addInfor(12, 0, R.raw.id12_part3, "");
        //Questions
        dbHelper.addQuestion("What is the conversation mainly about?",
                "Why and how a man lost his memory.",
                "Things turn worse with a loss of memory.",
                "Life of a man who lost his memory.",
                "A lost memory: a broken family.",
                "C",
                "Listening",
                12,
                3);
        dbHelper.addQuestion("Why did the man lose his memory?",
                "He had an accident.",
                "He has a virulent disease.",
                "He’s getting old.",
                "He has a genetic brain disease.",
                "B",
                "Listening",
                12,
                3);
        dbHelper.addQuestion("What is a result of his problem?",
                " Everything continually gets refreshed to him.",
                "He lives a sad life in a hospital.",
                "He often gets lost and hurt.",
                "His wife left him and remarried in the U.S.",
                "A",
                "Listening",
                12,
                3);
        dbHelper.addQuestion("If he says hello to a person at 8:00, when will he probably say hello again?",
                "8:07",
                "8:05:07",
                "8:30.",
                "8:00:07",
                "D",
                "Listening",
                12,
                3);
        dbHelper.addQuestion("What did his wife do for him before she left?",
                "She did charity and prayed for him.",
                "She took care of him for a long time.",
                "She worked in a new center to take care of him.",
                "She got good treatment for him in the U.S.",
                "B",
                "Listening",
                12,
                3);
        dbHelper.addQuestion("What happens when he meets his children?",
                "Sometimes he calls their names.",
                "They talk to him about their company",
                "He’s happy to see them.",
                "He tells them they do not need to come again",
                "C",
                "Listening",
                12,
                3);
        dbHelper.addQuestion("What is probably his favorite TV program?",
                "A football match.",
                "A game show.",
                "A comedy.",
                "A movie.",
                "A",
                "Listening",
                12,
                3);
        dbHelper.addQuestion("What will the female speaker probably do?",
                "Visit the sick man.",
                "Bring the sick man a piano.",
                "Playing the piano for the sick man.",
                "Wait to see the sick man on TV.",
                "D",
                "Listening",
                12,
                3);
        //ID_infor = 13, part = 4, type = Listening
        //Information
        dbHelper.addInfor(13, 0, R.raw.id13_part4, "The professor gives a/an (25) _____ of " +
                "globalization, which emphasizes the " +
                "acceleration and intensification of economic " +
                "transactions among people, companies and " +
                "(26) _____. He then cites the U.S., the " +
                "International Monetary Fund and the World " +
                "Bank as the examples of (27) _____ and two " +
                "big international organizations that first involve " +
                "globalization. The professor also names Coca " +
                "Cola, McDonald, popular music and (28) _____ " +
                "as representatives of U.S. cultural imperialism. " +
                "In the first point of the lecture, the professor " +
                "indicates that critics object to globalization " +
                "because poor countries are often badly " +
                "(29) _____ by international organizations to (i) " +
                "adjust currency, (ii) eliminate tariffs, (iii) respect " +
                "patents and copyright laws, (iv) privatize " +
                "(30) _____, and (v) not subsidize domestic " +
                "goods. To illustrate his point, the professor " +
                "gives an example of (31) _____, which suffered " +
                "rather than prospered. The professor then cites " +
                "the opinion of critics to globalization that these " +
                "organizations do not have good intentions to " +
                "help poor countries; they want to take " +
                "advantage of these countries instead. " +
                "However, the professor suggests two more " +
                "possible reasons for this practice. First, these " +
                "rules are also implemented to some extent in " +
                "rich countries. Second, poor countries which do " +
                "not follow trade rules will not receive (32) _____ " +
                "from rich countries.");
        //Questions
        dbHelper.addQuestion("(25) _____",
                "explanation",
                "definition",
                "clarification",
                "argument",
                "B",
                "Listening",
                13,
                4);
        //Questions
        dbHelper.addQuestion("(26) _____",
                "leaders of different continents",
                "different nations in many regions",
                "governments of various countries",
                "similar governments of some nations",
                "C",
                "Listening",
                13,
                4);
        //Questions
        dbHelper.addQuestion("(27) _____",
                "capitalism",
                "imperialism",
                "culturalism",
                "popularism",
                "A",
                "Listening",
                13,
                4);
        //Questions
        dbHelper.addQuestion("(28) _____",
                "TV celebrities",
                "computer programs",
                "advertising programs",
                "television shows",
                "D",
                "Listening",
                13,
                4);
        //Questions
        dbHelper.addQuestion("(29) _____",
                "supported",
                "directed",
                "advised",
                "financed",
                "C",
                "Listening",
                13,
                4);
        //Questions
        dbHelper.addQuestion("(30) _____",
                "large corporations",
                "all public businesses",
                "the business sector",
                "industry and banks",
                "D",
                "Listening",
                13,
                4);
        //Questions
        dbHelper.addQuestion("(31) _____",
                "South Korea",
                "South Africa",
                "Argentina",
                "Indonesia",
                "C",
                "Listening",
                13,
                4);
        //Questions
        dbHelper.addQuestion("(32) _____",
                "investments",
                "nonrefundable aids",
                "technology transfer",
                "economic counseling",
                "A",
                "Listening",
                13,
                4);
    }
}
