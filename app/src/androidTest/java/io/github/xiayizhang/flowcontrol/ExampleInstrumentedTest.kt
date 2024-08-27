package io.github.xiayizhang.flowcontrol

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        class ProxyServer(private val port: Int) {
            private val serverSocket: ServerSocket
            private val executorService: ExecutorService

            init {
                serverSocket = ServerSocket()
                executorService = Executors.newCachedThreadPool()
            }

            fun start() {
                try {
                    serverSocket.bind(InetSocketAddress(port))
                    println("Proxy server started on port $port")

                    while (true) {
                        val clientSocket = serverSocket.accept()
                        executorService.execute { handleClient(clientSocket) }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            private fun handleClient(clientSocket: Socket) {
                try {
                    val targetUrl = URL("http://example.com") // 替换为您要拦截的目标网站
                    val targetHost = targetUrl.host
                    val targetPort = targetUrl.port

                    val targetSocket = Socket(targetHost, targetPort)
                    val inputStream = clientSocket.getInputStream()
                    val outputStream = clientSocket.getOutputStream()
                    val targetInputStream = targetSocket.getInputStream()
                    val targetOutputStream = targetSocket.getOutputStream()

                    // 将客户端的请求转发到目标服务器
                    inputStream.copyTo(targetOutputStream)
                    targetOutputStream.flush()

                    // 将目标服务器的响应转发回客户端
                    targetInputStream.copyTo(outputStream)
                    outputStream.flush()

                    clientSocket.close()
                    targetSocket.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }      // Context of the app under test.

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.github.xiayizhang.flowcontrol", appContext.packageName)
    }
}
