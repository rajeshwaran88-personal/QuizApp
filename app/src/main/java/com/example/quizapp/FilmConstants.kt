package com.example.quizapp

object FilmConstants{
    fun getQuestions():ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()
        val que1 = Questions(1,"Which Marvel Superhero is this?",
            R.drawable.ic_thor,
            "Thor", "Captain America",
            "IronMan","HawkEye",1)

        questionsList.add(que1)

        val que2 = Questions(
            2, "Which Batman character is this?",
            R.drawable.ic_harleyquinn,
            "Catwoman", "Canary",
            "Harley Quinn", "Poison Ivy", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Questions(
            3, "Which Matrix character is this?",
            R.drawable.ic_trinity,
            "Neo", "Morpheus",
            "Smith", "Trinity", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Questions(
            4, "What Nolan movie is this?",
            R.drawable.ic_inception,
            "Interstellar", "Inception",
            "Batman Begins", "Memento", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Questions(
            5, "Who is this?",
            R.drawable.ic_potter,
            "Ron", "Hermione",
            "Harry", "Dumbledore", 3
        )

        questionsList.add(que5)

        return questionsList
    }
}