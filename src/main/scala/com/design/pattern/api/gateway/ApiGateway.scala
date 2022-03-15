package com.design.pattern.api.gateway

/**
 * Structural Pattern
 */

//--------[ Interface ]----------------------
trait VideoClient {
   def execute(): Unit
}

trait ImageClient {
  def execute(): Unit
}

//---------------[ Implementation ]---------------
class VideoClientImpl extends VideoClient {
  override def execute(): Unit = println("Video Client Running ...")
}

class ImageClientImpl extends ImageClient {
  override def execute(): Unit = println("Image Client Running ...")
}

//----------------[ API Gateway ]-----------------------
class ApiGateway(videoClient: VideoClient, imageClient: ImageClient){
  def handleImage(): Unit = imageClient.execute()

  def handleVideo(): Unit = videoClient.execute()
}

//-----------[ Run app ]---------------------------
object ApiGateway {
  def main(args: Array[String]): Unit = {
    val apiGateway = new ApiGateway(new VideoClientImpl, new ImageClientImpl)

    apiGateway.handleImage()
    apiGateway.handleVideo()
  }
}
