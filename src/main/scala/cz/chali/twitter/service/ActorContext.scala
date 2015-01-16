package cz.chali.twitter.service

import akka.stream.actor.ActorPublisher
import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.social.twitter.api.Tweet

@Configuration
class ActorContext {
    @Autowired
    var actorRefFactory: ActorRefFactory = _

    @Bean
    def twitterStreamPublisher(): Publisher[Tweet] = {
        ActorPublisher(actorRefFactory.getActorRef("twitterStreamHandlerActor", Seq("twitter")))
    }
}
