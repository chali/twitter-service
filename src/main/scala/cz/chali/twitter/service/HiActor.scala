package cz.chali.twitter.service

import akka.actor.Actor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.social.twitter.api.Tweet
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class HiActor extends Actor {

    @Autowired
    private var hiService: HiService = _

    override def receive: Receive = {
        case text: String => hiService.say(text)
        case response: Tweet =>
            print(response.getText)
    }
}
