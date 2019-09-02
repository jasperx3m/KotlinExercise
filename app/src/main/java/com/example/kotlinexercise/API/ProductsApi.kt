package com.example.kotlinexercise.API

import com.example.kotlinexercise.Models.Products
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
/*import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import sun.util.logging.LoggingSupport.setLevel
import java.util.concurrent.TimeUnit
import javax.net.ssl.*
import javax.security.cert.CertificateException
import sun.util.logging.LoggingSupport.setLevel
import okhttp3.Interceptor*/


const val QUICKREACH_URL : String = "http://10.0.2.2/api/"

interface ProductsApi {
    @GET("products")
    fun getProducts() : Call<MutableList<Products>>
    companion object{
        operator fun invoke() : ProductsApi{
            return Retrofit.Builder()
                .baseUrl(QUICKREACH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductsApi::class.java)
        }
    }
}

/*
private fun interceptor(): OkHttpClient.Builder {


    val interceptor : Interceptor
    interceptor.setLevel(Interceptor {  }.Level.BODY)

    try {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager() {

            val acceptedIssuers: Array<java.security.cert.X509Certificate>
                get() = arrayOf()

            @Throws(CertificateException::class)
            override fun checkClientTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }
        })

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())

        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.getSocketFactory()

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.writeTimeout(60, TimeUnit.SECONDS)
        builder.build()

        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        builder.hostnameVerifier(object : HostnameVerifier {
            override fun verify(hostname: String, session: SSLSession): Boolean {
                return true
            }
        })
        return builder
    } catch (e: Exception) {
        throw RuntimeException(e)
    }


}
*/
