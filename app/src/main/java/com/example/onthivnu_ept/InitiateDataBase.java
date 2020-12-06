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
        dbHelper.addInfor(13, 0, R.raw.id13_part4, "The professor gives a/an (25) _____ of  " +
                "globalization, which emphasizes the  " +
                "acceleration and intensification of economic  " +
                "transactions among people, companies and  " +
                "(26) _____. He then cites the U.S., the  " +
                "International Monetary Fund and the World  " +
                "Bank as the examples of (27) _____ and two  " +
                "big international organizations that first involve  " +
                "globalization. The professor also names Coca  " +
                "Cola, McDonald, popular music and (28) _____  " +
                "as representatives of U.S. cultural imperialism.  " +
                "In the first point of the lecture, the professor  " +
                "indicates that critics object to globalization  " +
                "because poor countries are often badly  " +
                "(29) _____ by international organizations to (i)  " +
                "adjust currency, (ii) eliminate tariffs, (iii) respect  " +
                "patents and copyright laws, (iv) privatize  " +
                "(30) _____, and (v) not subsidize domestic  " +
                "goods. To illustrate his point, the professor  " +
                "gives an example of (31) _____, which suffered  " +
                "rather than prospered. The professor then cites  " +
                "the opinion of critics to globalization that these  " +
                "organizations do not have good intentions to  " +
                "help poor countries; they want to take  " +
                "advantage of these countries instead.  " +
                "However, the professor suggests two more  " +
                "possible reasons for this practice. First, these  " +
                "rules are also implemented to some extent in  " +
                "rich countries. Second, poor countries which do  " +
                "not follow trade rules will not receive (32) _____  " +
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
        //ID_infor = 14, part = 1 (11, 12), type = Reading
        //Information
        dbHelper.addInfor(14, 0, 0, "\tTOURISTS IN A FRAGILE LAND\n" +
                "1. As a scientist working in Antarctica, I spend most of (33) _____ time in the lab studying ice. I " +
                "am trying to find out the age of Antarctic ice. All we know for certain is that it is the oldest ice " +
                "in the world. The more we understand it, the more we will understand the (34) _____ " +
                "weather of the Earth. Today, as with an increasing number of days, I had to leave my work " +
                "to greet a group of tourists who were taking a vacation in this continent of ice. And even " +
                "though I can appreciate their desire to experience this vast and beautiful landscape, I feel " +
                "Antarctica should be closed to tourists.\n" +
                "2. Because Antarctica is the center of important scientific research, it must (35) _____ " +
                "preserved for this purpose. Meteorologists are now looking at the effects of the ozone hole " +
                "that was discovered above Antarctica in 1984. They are also trying to understand global " +
                "warming. If the Earth’s temperature continues to increase, the health and safety of every " +
                "living thing on the planet will be affected. Astronomers have a unique view of space and are " +
                "able to see it very (36) _____ from Antarctica. Biologists have a chance to learn more about " +
                "the animals that inhabit the coastal areas of this frozen land. Botanists study the plant life to " +
                "understand how it can live in such a harsh environment, and geologists study the Earth to " +
                "learn more about how it was formed. There are even psychologists who study how people " +
                "behave when they live and work together in such a remote location.\n" +
                "3. When tourist groups come here, they take us away from our research. Our work is difficult, and " +
                "some of our projects can be damaged by such simple mistakes as opening the wrong door or " +
                "bumping into a small piece of equipment. Tourists in Antarctica can also hurt the environment. " +
                "Members of Greenpeace, one of the world’s leading environmental organizations, (37) _____ " +
                "that tourists leave trash on beaches and disturb the plants and animals. In a place as frozen " +
                "as Antarctica, it can take 100 years for a plant (38) _____ back, and tourists can easily " +
                "damage penguin eggs. Oil spills are another problem caused by tourism. Oil spills not only kill " +
                "penguins but can also destroy scientific projects.\n" +
                "4. The need to protect Antarctica from tourists becomes even (39) _____ when we " +
                "consider the fact that there is no government here. Antarctica belongs to no country. " +
                "Who is making sure that the penguins, plants, and sea are safe? No one is responsible. " +
                "In fact, we scientists are only temporary visitors ourselves. It is true that the number of " +
                "tourists (40) _____ visit Antarctica each year is small compared to the number of those " +
                "who visit other places. However, these other places are inhabited by local residents and " +
                "controlled by local governments. They have an interest in protecting their natural " +
                "environments. Who is concerned about the environment of Antarctica? The scientists, to " +
                "be sure, but not necessarily the tour companies that make money from sending people " +
                "south.\n" +
                "5. If we don’t protect Antarctica from tourism, there (41) _____ be serious consequences for " +
                "us all. We might lose the results of scientific research projects. It’s possible that these results " +
                "could teach us (42) _____ about the causes and effects of climate change. Some fragile " +
                "plants and animals might die and disappear forever. This could damage the balance of " +
                "animal and plant life in Antarctica. We know from past experience that when things get " +
                "unbalanced, harmful changes can occur. Clearly, Antarctica should remain a place for " +
                "careful and controlled scientific research. We cannot allow tourism to bring possible danger " +
                "to the planet. The only way to protect this fragile and important part of the planet is to stop " +
                "tourists from traveling to Antarctica.");
        //Questions
        dbHelper.addQuestion("(33) _____",
                "our",
                "his",
                "her",
                "my",
                "D",
                "Reading",
                14,
                11);
        //Questions
        dbHelper.addQuestion("(34) _____",
                "changed",
                "change",
                "changing",
                "changes",
                "C",
                "Reading",
                14,
                11);
        //Questions
        dbHelper.addQuestion("(35) _____",
                "have",
                "be",
                "make",
                "do",
                "B",
                "Reading",
                14,
                11);
        //Questions
        dbHelper.addQuestion("(36) _____",
                "clearly",
                "clarity",
                "clear",
                "unclearly",
                "A",
                "Reading",
                14,
                11);
        //Questions
        dbHelper.addQuestion("(37) _____",
                "complaining",
                "complain",
                "complaint",
                "complained",
                "B",
                "Reading",
                14,
                11);
        dbHelper.addQuestion("(38) _____",
                "to grow",
                "growing",
                "grow",
                "growth",
                "A",
                "Reading",
                14,
                11);
        dbHelper.addQuestion("(39) _____",
                "great",
                "greater",
                "greatest",
                "most great",
                "B",
                "Reading",
                14,
                11);
        dbHelper.addQuestion("(40) _____",
                "which",
                "whom",
                "who",
                "where",
                "C",
                "Reading",
                14,
                11);
        dbHelper.addQuestion("(41) _____",
                "would",
                "need",
                "ought to",
                "may",
                "D",
                "Reading",
                14,
                11);
        dbHelper.addQuestion("(42) _____",
                "important thing",
                "importance",
                "importantly",
                "something importan",
                "D",
                "Reading",
                14,
                11);
        dbHelper.addQuestion("The word 'vast' in paragraph 1 is closest in meaning to _____.",
                "very large",
                "pretty",
                "small",
                "faraway",
                "A",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word landscape in paragraph 1 is closest in meaning to _____.",
                "an area of land for living",
                "a painting",
                "an icy environment",
                "the way an area of land looks",
                "D",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word preserved in paragraph 2 is closest in meaning to _____.",
                "closed",
                "explored",
                "protected",
                "changed",
                "C",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word inhabit in paragraph 2 is closest in meaning to _____.",
                "avoid",
                "cover",
                "prefer",
                "live in",
                "D",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word harsh in paragraph 2 is closest  in meaning to _____.",
                "unpleasantly difficult",
                "mild",
                "dry",
                "cold",
                "A",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word remote in paragraph 2 is closest in meaning to _____.",
                "ideal",
                "isolated",
                "hostile",
                "lonely",
                "B",
                "Reading",
                14,
                12);
        dbHelper.addQuestion(". The word disturb in paragraph 3 is closest in meaning to _____.",
                "make somebody/something happy",
                "bring somebody/something comfort",
                "annoy somebody/something",
                "cause somebody/something to die",
                "C",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word temporary in paragraph 4 is closest in meaning to _____.",
                "rich and adventurous",
                "careful",
                "lasting for a limited time",
                "responsible",
                "C",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word consequences in paragraph 5  is closest in meaning to _____.",
                "acquaintances",
                "effects",
                "causes",
                "disasters",
                "B",
                "Reading",
                14,
                12);
        dbHelper.addQuestion("The word fragile in paragraph 5 is closest  in meaning to _____.",
                "native",
                "rare",
                "useful",
                "easily damaged",
                "D",
                "Reading",
                14,
                12);
        //ID_infor = 15, part = 2, type = Reading
        //Information
        dbHelper.addInfor(15, 0, 0, "The white face, dark eyes and hair, and blood red lips: both foreigners and the Japanese are  " +
                "fascinated by these beautiful and mysterious women.\n" +
                "Makiko is training to be a geisha. Not many girls want to be a geisha in Japan today. Makiko’s  " +
                "parents want her to go to university, study medicine and become a doctor. But Makiko’s  " +
                "grandfather paid for her training and bought the kimonos she needed. It’s very expensive to  " +
                "become a geisha. You have to have a different kimono for each month of the year, and today  " +
                "a kimono costs three million yen, that’s about $30.000.\n" +
                "It’s a hard life for a trainee geisha. She has to leave her family and move to a special boarding  " +
                "house called a ‘maiko house’. Here, she has to learn traditional Japanese arts such as playing  " +
                "instruments, performing the tea ceremony, arranging flowers, singing and dancing. She has  " +
                "to take many difficult tests and exams. Only the best will pass everything and become geishas  " +
                "many years later.\n" +
                "We asked Makiko to describe exactly what a geisha does.\n" +
                "‘A geisha has to serve customers and also entertain them. She has to sing and dance, and  " +
                "make good conversations.’\n" +
                "Did she enjoy her life as a trainee geisha?\n" +
                "‘I love it. But it’s hard work. Sometimes I get tired of wearing the kimonos and I want to put on  " +
                "a pair of jeans and go to school like a normal teenager. But I can’t have a normal life now. I  " +
                "don’t mind. I feel very lucky.’\n" +
                "And what about later? Can she have a family?\n" +
                "‘Of course. A geisha can have relationships like anybody else and she can get married when  " +
                "she chooses.’\n" +
                "In Japan today there are fewer than a thousand geishas, but they play an important role in  " +
                "preserving Japanese culture and history");
        //Questions
        dbHelper.addQuestion("What is the main idea of the passage?",
                "How to be a famous geisha.",
                "Interesting life of geishas.",
                "Life and work of geishas.",
                "How geishas feel about their life.",
                "C",
                "Reading",
                15,
                2);
        dbHelper.addQuestion("Why is Makiko training to be a geisha?",
                "Her parents want her to do so.",
                "Her grandfather supported her financially.",
                "She was lucky to be chosen.",
                "Being a geisha is Makiko’s dream.",
                "A",
                "Reading",
                15,
                2);
        dbHelper.addQuestion("What is NOT a requirement for a geisha?",
                "She has to pass all difficult tests and exams. ",
                "She can’t stay home during the training.",
                "She has to learn music.",
                "She has to play modern instruments.",
                "D",
                "Reading",
                15,
                2);
        dbHelper.addQuestion("The word She in the passage refers to ____",
                "Makiko",
                "A trainee geisha",
                "The writer",
                "A family member",
                "B",
                "Reading",
                15,
                2);
        dbHelper.addQuestion("Why does the writer mention tea ceremony?",
                "To express he/she likes tea.",
                "To indicate that geishas love tea.",
                "To give an example of Japanese traditional arts.",
                "To show that all Japanese drink tea in a special way",
                "C",
                "Reading",
                15,
                2);
        dbHelper.addQuestion("The word them in the passage refers to ____.",
                "geishas",
                "tests and exams",
                "customers",
                "conversations",
                "C",
                "Reading",
                15,
                2);
        //ID_infor = 16, part = 3, type = Reading
        //Information
        dbHelper.addInfor(16, 0, 0, "1. Climate encompasses the statistics of temperature, humidity, atmospheric pressure, wind, " +
                "rainfall, atmospheric particle count and other meteorological elements in a given region over a " +
                "long period of time. Climate can be contrasted to weather, which is the present condition of " +
                "these same elements and their variations over shorter time periods.\n" +
                "2. Climate may be inherently variable as evidenced by the irregularity of the seasons from one " +
                "year to another. This variability is normal and may remain partially understood. It is related to " +
                "changes in ocean currents, volcanic eruptions, solar radiation and other components of the " +
                "climate system. In addition, our climate has its extremes (such as floods, droughts, hail, " +
                "tornadoes and hurricanes), which can be devastating. However, in recent decades, a number " +
                "of indicators and studies show more and more evidence of climate warming across the globe. " +
                "It is a disturbing phenomenon challenging human habits and activities which are responsible " +
                "for greenhouse gas emissions.\n" +
                "3. The greenhouse effect is the process by which absorption and emission of infrared radiation " +
                "by gases in the atmosphere warm the planet's lower atmosphere and surface. It was proposed " +
                "by Joseph Fourier in 1824 and was first investigated quantitatively by Svante Arrhenius in " +
                "1896. Naturally occurring greenhouse gases have a mean warming effect of about 33°C " +
                "(59°F). But human activity since the Industrial Revolution has increased the amount of " +
                "greenhouse gases in the atmosphere, leading to increased concentrations of CO2 and " +
                "methane. The concentrations of CO2 and methane have increased by 36% and 148% " +
                "respectively since 1750. These levels are much higher than at any time during the last " +
                "650,000 years. Over the last three decades of the 20th century, GDP (Gross Domestic " +
                "Product) per capita and population growth were the main drivers of increases in greenhouse " +
                "gas emissions. CO2 emissions are continuing to rise due to the burning of fossil fuels and " +
                "land-use change.\n" +
                "4. There are two major effects of global warming: the increase of temperature on the earth by " +
                "about 3° to 5°C (5.4° to 9°F) by the year 2100, and the rise of sea levels by at least 25 meters " +
                "(82 feet) by the year 2100. Other consequences are listed below: \n" +
                "- Amounts and patterns of precipitation are changing.\n" +
                "- The total annual power of hurricanes has already increased markedly since 1975 because" +
                "their average intensity and average duration have increased.\n" +
                "- Changes in temperature and precipitation patterns increase the frequency, duration, and " +
                "intensity of other extreme weather events, such as floods, droughts, heat waves, and " +
                "tornadoes.\n" +
                "- Lower agricultural yields, further glacial retreat, reduced summer stream flows and species " +
                "extinctions.\n" +
                "- Diseases like malaria are returning to areas where they have been extinguished earlier.");
        //Questions
        dbHelper.addQuestion("What is the passage mainly about?",
                "Differences between weather and climate",
                "Global warming and its effects",
                "Climate warming across the globe.",
                "Consequences of global warming by 2100.",
                "B",
                "Reading",
                16,
                3);
        //Questions
        dbHelper.addQuestion("According to paragraph 1, what differentiates climate from weather?",
                "Elements",
                "Temperatures",
                "Time periods",
                "Locations",
                "C",
                "Reading",
                16,
                3);
        //Questions
        dbHelper.addQuestion("The word It in paragraph 2 refers to ____.",
                "number",
                "evidence",
                "globe",
                "climate warming",
                "D",
                "Reading",
                16,
                3);
        //Questions
        dbHelper.addQuestion(" It can be inferred from paragraph 2 tha _____.",
                "climate changes from one year to another",
                "scientists may not fully understand climate variability",
                "climate extremes have just occurred in recent decades",
                "humans produce more gases in greenhouses",
                "B",
                "Reading",
                16,
                3);
        //Questions
        dbHelper.addQuestion("Why does the author mention fossil fuels in paragraph 3?",
                "To give an example of a source of CO2 emissions.",
                "To indicate that fossil fuels burn well.",
                "To confirm that fossil fuels are the only cause of CO2 emissions.",
                "To show the relation between fossil fuels and land-use change.",
                "A",
                "Reading",
                16,
                3);
        //Questions
        dbHelper.addQuestion("What can be inferred from paragraph 3?",
                "The greenhouse gases in nature have a warming effect of about 33*C on average",
                "The concentrations of CO2 and methane have increased by 36% since 1750.",
                "The Industrial Revolution began in 1750.",
                "Population growth caused serious gas emissions in the 19th century.",
                "C",
                "Reading",
                16,
                3);
        //Questions
        dbHelper.addQuestion("According to paragraph 3, what is a cause of the continued increase of CO2 emissions?",
                "The production of fuels",
                "The use of man-made fuels",
                "The changed use of land.",
                "The clearing of land for living.",
                "C",
                "Reading",
                16,
                3);
        //Information
        dbHelper.addInfor(17, R.drawable.id17_part4, 0, "\tCOLUMBIAN EXCHANGE\n" +
                "1. The Columbian Exchange was the “exchange of plants, animals, foods, human populations " +
                "(including slaves) communicable diseases, and ideas between the Eastern and Western " +
                "hemispheres that occurred after 1492.” The term “Columbian Exchange,” coined in 1972 by " +
                "historian Alfred Crosby, took hold and became not only standard shorthand for the " +
                "phenomenon which it exemplified, but also a perspective for witnessing societal and " +
                "ecological events.\n" +
                "2. When Christopher Columbus made landfall with his crew in the Bahamas in October " +
                "1492, two worlds with separate evolutionary histories met. When Europeans began to " +
                "settle America’s east coast, they brought with them and cultivated familiar crops – wheat " +
                "and apples – as well as familiar weeds, such as dandelion and chickweed. In the 1600s, " +
                "they introduced cattle and horses, which flourished in the New World climate.\n" +
                "3. Devastating diseases were introduced to the American population which had no resistance " +
                "to them. John R. McNeill, professor of history at Georgetown University, points out that " +
                "“when the first inhabitants of the Americas arrived across the Bering land bridge between " +
                "20,000 and 12,000 years ago, they brought few diseases with them because they had no " +
                "domesticated animals, the original source of human diseases such as smallpox and " +
                "measles. In addition, as they passed from Siberia to North America, the first Americans had " +
                "spent many years in extreme cold, which eliminated many of the disease-causing agents " +
                "that might have traveled with them.” Consequently, between 1492 and 1650, over 90% of " +
                "the Native American population died in epidemic after epidemic of smallpox, measles, " +
                "mumps, whooping cough, influenza, chicken pox, and typhus. The loss of labor caused by " +
                "pathogens indirectly led to the establishment of African slavery among European immigrants " +
                "in the Americas, resulting in the importation of malaria and yellow fever from Africa, causing " +
                "even more destruction of the Native American population.\n" +
                "4. The export of American flora and fauna did not revolutionize the Old World as the influx of " +
                "European agriculture altered the New World ecosystem. According to Crosby, the New " +
                "World’s great contribution to the Old World was crop plants. Maize, white potatoes, sweet " +
                "potatoes, various squashes, chilies, and manioc augmented and invigorated the European " +
                "cuisine. Very few New World creatures traversed the ocean - the muskrat, the gray squirrel, " +
                "and a few others - but they did not precipitate large scale changes in Old World ecosystems.\n" +
                "5. Although some diseases made the ocean voyage from New World to the Old World, they did " +
                "not have appreciable effects on the European population. Crosby stated that, although some " +
                "deaths were attributed to ailments from America, the total was insignificant compared to " +
                "Native American losses to smallpox alone. 6 In Crosby’s original work, he eschewed ideological statements. He reminded his readers " +
                "that neither the Old nor the New World was inferior or superior to the other, and the " +
                "encounter between the two worlds was fundamentally an exchange. By 1988, he " +
                "summarized his long view of the encounter in this way: “My point is that the impact of the " +
                "Encounter is so massive that we should consider it with the same sense of scale as we do " +
                "events connected with the endings and beginnings of the geological periods and eras and " +
                "their influence on the direction of evolution on the planet.”");
        //Questions
        dbHelper.addQuestion("What is the passage mainly about?",
                "Exchanged things between Columbus and Native Americans.",
                "Social and ecological development of the Americas after 1492.",
                "Inferiority of the New World to the Old World.",
                "Exchanges between the Americas and other continents since 1492.",
                "D",
                "Reading",
                17,
                4);
        //Questions
        dbHelper.addQuestion("Which sentence below best restates the meaning of the highlighted sentence in paragraph 2?",
                "When Christopher Columbus " +
                        "reached the Bahamas in October " +
                        "1492, he fell on the land.",
                "When Columbus’s group set foot on " +
                        "the Americas, the Old World and the " +
                        "New World encountered.",
                "Christopher Columbus claimed the " +
                        "honor of discovering two separate " +
                        "evolutionary histories.",
                "The Bahamas were the land where " +
                        "Christopher Columbus met the " +
                        "inhabitants of the New World.",
                "B",
                "Reading",
                17,
                4);
        //Questions
        dbHelper.addQuestion("Why does the author mention wheat and " +
                        "apples in paragraph 2?",
                "To show the two familiar crops grown " +
                        "in the Americas.",
                "To indicate that they are more " +
                        "familiar than weeds and cattle",
                "To give two examples of European " +
                        "crops brought to America.",
                "To explain which crops Americans " +
                        "chose to cultivate.",
                "C",
                "Reading",
                17,
                4);
        //Questions
        dbHelper.addQuestion("The word them in paragraph 3 refers to " +
                        "_____. ",
                "inhabitants",
                "Americans",
                "the Americas",
                "diseases",
                "D",
                "Reading",
                17,
                4);
        //Questions
        dbHelper.addQuestion(". According to paragraph 3, between 1492 " +
                        "and 1650, Native Americans died of the " +
                        "following European epidemics EXCEPT " +
                        "_____.",
                "mumps",
                "influenza",
                "malaria",
                "chicken pox",
                "C",
                "Reading",
                17,
                4);
        //Questions
        dbHelper.addQuestion(". It can be inferred from paragraph 4 that _____.",
                "the Columbian Exchange had more important impact on the Americas than on Europe",
                "more Europeans liked the Old World’s crops",
                "the New World animals did not change the Old World ecosystems",
                "the muskrat and the gray squirrel were the Old World creatures",
                "A",
                "Reading",
                17,
                4);
        //Questions
        dbHelper.addQuestion("Which of the following best demonstrates the Columbian Exchange?",
                "malaria and yellow fever",
                "crops, weeds, cattle and horses",
                "disease-causing agents",
                "smallpox and measles",
                "B",
                "Reading",
                17,
                4);
    }
}
