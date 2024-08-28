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
import java.net.DatagramPacket
import java.net.DatagramSocket

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun main() {
    val port = 554
    val bufferSize = 1024

    try {
        // 创建一个DatagramSocket实例，监听指定的端口
        val socket = DatagramSocket(port)

        println("正在监听$port端口...")

        while (true) {
            // 创建一个缓冲区来接收数据包
            val buffer = ByteArray(bufferSize)
            val packet = DatagramPacket(buffer, buffer.size)

            // 接收数据包
            socket.receive(packet)

            // 打印接收到的数据包的信息
            println("收到${packet.address}:${packet.port}的数据包")
            println("内容${String(packet.data, 0, packet.length)}")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}     // Context of the app under test.

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.github.xiayizhang.flowcontrol", appContext.packageName)
    }
}
