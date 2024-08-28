# FlowController
an Android flow controller, write by Kotlin <br>
i didn't build it. and there're too many bugs.<br>
Limited by my programming skills and time constraints, maybe it's only an idea<br>
let's make it perfect.<br>
With the development of mobile communication in recent years, there has been a large increase in Cellular data services. But with that comes a lot of vexing problems. For example, endless advertising consumes our precious traffic, and even some apps force video and live broadcast. According to statistics, 720p video playback one minute requires about 7.68mb of traffic, the common 1080p video playback one minute requires about 26.25mb of traffic; The traffic occupied by ordinary audio quality is usually about 1MB/ minute; A picture is about 100kb-2mb.
Often the mobile phone plays automatically when it is off silent, unconsciously consuming a lot of traffic. Once, when I went out to eat, I clicked on QQ "一起听歌" service, and the result was unable to exit, resulting in the consumption of a lot of traffic. Usually, when parents browse Taobao and other shopping websites and apps, they will automatically play live broadcasts and videos. Turning off autoplay manually is cumbersome, or even impossible.<br>
So I decided to write an open source software that would get the packet title or type through an agent and discard the packet if it was video, audio, or a specific URL. This saves traffic and prevents software overflow vulnerabilities, SEH vulnerabilities, and even DDoS attacks.<br>
At present, the Protocol used in most app video transmission is RTSP (Real Time Streaming Protocol) protocol. By creating a DatagramSocket instance, listening to port 554, intercept all packets. When a user chooses to watch a specified video, packets with a specified IP address are allowed to be received.<br>

