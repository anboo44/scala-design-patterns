package com.design.pattern.adapter

/** -- Definition --
 * Adapter Pattern is a structural design pattern that convert the interface of a class into another interface clients expect.
 * Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces
 */

/** -- Example --
 *   VietnameseClient ---> VietnameseTarget: [ def send ]
 *                                 *
 *                                 *
 *                                 *
 *                      TranslatorAdapter(adaptee)  <----- JapaneseAdaptee: [ def receive ]
 *                         override def send
 *                         private def translate
 */

trait VietnameseTarget {
  def send(word: String): Unit
}

class TranslatorAdapter(adaptee: JapaneseAdaptee) extends VietnameseTarget {
  override def send(word: String): Unit = {
    println(s"-> Receive word: ${word}")
    val jpWord = translate(word)
    adaptee.receive(jpWord)
  }

  private def translate(word: String): String = {
    println("-> Start to translate...")
    println("-> Finish to translate!")

    "知つさぼ式7慰"
  }
}

class JapaneseAdaptee {
  def receive(word: String): Unit = {
    println(s"-> Word in Japanese: $word")
  }
}

object VietnameseClient {
  def main(args: Array[String]): Unit = {
    val translator: VietnameseTarget = new TranslatorAdapter(new JapaneseAdaptee)
    translator.send("Lorem ipsum")
  }
}
