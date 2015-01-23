package cz.chali.twitter.service

import akka.stream.actor.ActorSubscriberMessage.OnNext
import akka.stream.actor.{WatermarkRequestStrategy, RequestStrategy, ActorSubscriber}
import org.springframework.context.annotation.Scope
import org.springframework.social.twitter.api.Tweet
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class ConsoleActorSubscriber extends ActorSubscriber {

    override protected def requestStrategy: RequestStrategy = WatermarkRequestStrategy(10)

    override def receive: Receive = {
        case OnNext(tweet: Tweet) => println(tweet.getText)
    }
}
