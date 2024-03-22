package com.affan.bcas_app.data

import com.affan.bcas_app.model.MenuDashboardResponse
import retrofit2.Response
import retrofit2.http.GET

interface Service {
//    https://private-00fe4e-affandn.apiary-mock.com/menu-
//    retrofit : library untuk komunikasi ke http request (GET)
    @GET("menu-dashboard")
    suspend fun getHomeMenu() : Response<MenuDashboardResponse>
}