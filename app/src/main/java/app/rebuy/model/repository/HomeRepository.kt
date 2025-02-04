package app.rebuy.model.repository

import app.rebuy.R
import app.rebuy.model.data.DataItem
import app.rebuy.model.data.New_Arrivals_Item_Model
import javax.inject.Inject

class HomeRepository @Inject constructor(){
    fun getAllSectionsData(): List<DataItem>{

        val list = listOf(
            New_Arrivals_Item_Model(R.drawable.product_thumbnail, "Batman Toy", 2018, "Funskool", 899),
            New_Arrivals_Item_Model(R.drawable.product_thumbnail, "Moby Dick", 1851, "Adventure", 15),
            New_Arrivals_Item_Model(R.drawable.product_thumbnail_two, "1984", 1949, "Dystopian", 12),
            New_Arrivals_Item_Model(R.drawable.product_thumbnail, "Hamlet", 1603, "Drama", 20)
        )

        val sectionList = listOf(
            DataItem("New Arrivals", list),
            DataItem("Recently Viewed", list),
            DataItem("Old Viewed", list)
        )
        return sectionList


    }

}