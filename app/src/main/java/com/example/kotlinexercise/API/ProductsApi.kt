package com.example.kotlinexercise.API

import android.util.Log
import com.example.kotlinexercise.Models.PostProducts
import com.example.kotlinexercise.Models.Products
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.http.*
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import retrofit2.http.DELETE




/*import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import sun.util.logging.LoggingSupport.setLevel
import java.util.concurrent.TimeUnit
import javax.net.ssl.*
import javax.security.cert.CertificateException
import sun.util.logging.LoggingSupport.setLevel
import okhttp3.Interceptor*/


const val QUICKREACH_URL : String = "https://10.0.2.2:5001/api/"

interface ProductsApi {
    companion object{

        operator fun invoke() : ProductsApi{
            Log.d("TAG", "message")
            var okHttpClient : OkHttpClient = UnsafeOkHttpClient().getUnsafeOkHttpClient()
            return Retrofit.Builder()
                .baseUrl(QUICKREACH_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductsApi::class.java)

        }
    }


    @GET("products")

    fun getProducts() : Call<MutableList<Products>>

    /*@FormUrlEncoded*/
    @POST("products")
    fun createProduct(
        @Body products: PostProducts
        /*@Field("name") name: String,
        @Field("description") description : String,
        @Field("price") price : String,
        @Field("imageUrl") imageUrl : String,
        @Field("isActive") isActive: String*/
    ) : Call<PostProducts>
    @PUT("products/{id}")
    fun updateProduct(
        @Path("id" )id:String,
        @Body product: Products
    ) : Call<Products>

    @DELETE("products/{id}")
    fun deleteProduct(
        @Path("id") id: String
    ) : Call<Products>

}

class UnsafeOkHttpClient {

    fun getUnsafeOkHttpClient(): OkHttpClient {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(
                p0: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            override fun checkServerTrusted(
                p0: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            override fun getAcceptedIssuers(): Array<out X509Certificate>? {
                return arrayOf<X509Certificate>()
            }
        })

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory

        return OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }.build()
    }
    /*fun getUnsafeOkHttpClient(): OkHttpClient {
        try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {

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

                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                    return arrayOf()
                }
            })
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { hostname, session -> true }

            return builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }*/
}

/*private fun disableSSLCertificateChecking() {
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
            return arrayOf()
        }

        @Throws(CertificateException::class)
        override fun checkClientTrusted(
            p0: Array<out java.security.cert.X509Certificate>?,
            arg1: String?
        ) {
            // Not implemented
        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(
            p0: Array<out java.security.cert.X509Certificate>?,
            arg1: String?
        ) {
            // Not implemented
        }
    })

    try {
        val sc = SSLContext.getInstance("TLS")

        sc.init(null, trustAllCerts, java.security.SecureRandom())

        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
    } catch (e: KeyManagementException) {
        e.printStackTrace()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

}*/



/*
fun main(args: Array<String>) {
    val urlPath = "https://google.com"
    try {
        (URL(urlPath).openConnection() as HttpsURLConnection).apply {
            sslSocketFactory = createSocketFactory(listOf("TLSv1.2"))
            hostnameVerifier = HostnameVerifier { _, _ -> true }
            readTimeout = 5_000
        }.inputStream.use {
            it.copyTo(System.out)
        }
    } catch (e: Exception) {
        TODO()
    }
}


private fun createSocketFactory(protocols: List<String>) =
    SSLContext.getInstance(protocols[0]).apply {
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, authType: String?) =Unit

            override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) =Unit

            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> =arrayOf()

        })
        init(null, trustAllCerts, SecureRandom())
    }.socketFactory

*/
