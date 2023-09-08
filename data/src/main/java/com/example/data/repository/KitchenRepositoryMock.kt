package com.example.data.repository

import android.content.Context
import com.example.data.R
import com.example.data.room.KitchenDao
import com.example.domain.model.CategoryModel
import com.example.domain.model.HomeButtonModel
import com.example.domain.model.HomeModel
import com.example.domain.model.HomePopularModel
import com.example.domain.repository.KitchenRepository


class KitchenRepositoryMock(private  val context:Context, private val kitchenDao:KitchenDao):KitchenRepository {

    override  fun getHomeImgFood(id: String): List<HomePopularModel> {

        try {
            val homePopulap = listOf(
                HomePopularModel(
                    "1", R.drawable.img1, context.getString(R.string.name_braekfast), "200 g", "320 kcal", "14 g", "10 g", "42 g",
                    "20 g", context.getString(R.string.breakfast), context.getString(R.string.breakfastinfo)
                ),
                HomePopularModel(
                    "2", R.drawable.pizza, context.getString(R.string.name_pizza), "150 g", "90 kcal", "2 g", "0 g", "20 g",
                    "10 г", context.getString(R.string.pizza),
                    context.getString(R.string.pizzainfo)
                ),
                HomePopularModel(
                    "3", R.drawable.patotes, context.getString(R.string.name_patotes), "250 g", "180 kcal", "8 g", "5 g", "30 g",
                    "3 g", context.getString(R.string.popates),
                    context.getString(R.string.popatesinfo)
                ),
                HomePopularModel(
                    "4", R.drawable.chicken_soupe, context.getString(R.string.name_chicken), "180 g", "250 kcal", "10 g", "15 g", "20 g",
                    "40 g", context.getString(R.string.chicken),
                    context.getString(R.string.chikceninfo)
                )
            )
            kitchenDao.insertHomePopularList(homePopulap)

            return kitchenDao.getHomePopular()
        } catch (e:Exception){
            return kitchenDao.getHomePopular()
        }

    }

    override fun getHomeFood(id: String): List<HomeModel> {
        return listOf(
            HomeModel(
            "1", R.drawable.img_food1
            ),
            HomeModel(
                "2", R.drawable.pizza
            ),
            HomeModel(
                "3", R.drawable.patotes
            ),
            HomeModel(
                "4", R.drawable.seafood
            ),
            HomeModel(
                "5", R.drawable.sendwich
            ),
            HomeModel(
                "6", R.drawable.chicken_soupe
            ),
            )
    }

    override fun getHomeButton(): List<HomeButtonModel> {
        return listOf(
            HomeButtonModel(context.getString(R.string.name_france)),
            HomeButtonModel(context.getString(R.string.name_russia)),
            HomeButtonModel(context.getString(R.string.name_england)),
            HomeButtonModel(context.getString(R.string.name_india)),
            HomeButtonModel(context.getString(R.string.name_italiano))
        )
    }

    override fun getCategory(): List<CategoryModel> {
        return listOf(
            CategoryModel(
                R.drawable.img_food1,
                context.getString(R.string.name_france), context.getString(R.string.name_croisssants), "100 g", "220 g", "280 g", "60 g",
                "50g ", "70 g",
                context.getString(R.string.croisants),
                context.getString(R.string.croisantsinfo),
            ),
            CategoryModel(
                R.drawable.patotes,
                context.getString(R.string.name_russia),
                context.getString(R.string.name_patotes),
                "250 g",
                "250 g",
                "180 g",
                "50 g",
                "40 g",
                "40 g",
                context.getString(R.string.popates),
                context.getString(R.string.popatesinfo)
            ),
            CategoryModel(
                R.drawable.sendwich,
                context.getString(R.string.name_england),
                context.getString(R.string.name_sandwich),
                "300 g",
                "600 g",
                "260 g",
                "40 g",
                "20 g",
                "50 g",
                context.getString(R.string.sandwich),
                context.getString(R.string.sandwichinfo)
            ),
            CategoryModel(
                R.drawable.chicken_soupe,
                context.getString(R.string.name_india),
                context.getString(R.string.name_chicken),
                "200 g",
                "350 g",
                "220 g",
                "70 g",
                "30 g",
                "70 g",
                context.getString(R.string.chicken),
                context.getString(R.string.chikceninfo)
            ),
            CategoryModel(
                R.drawable.pizza,
                context.getString(R.string.name_italiano),
                context.getString(R.string.name_pizza),
                "150 g",
                "200 g",
                "180 g",
                "30 g",
                "60 g",
                "80 g",
                context.getString(R.string.pizza),
                context.getString(R.string.pizzainfo)
            )
        )

    }
}