require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Let's start.
        a: yoy
        intent: /how do you do || toState = "/fine"
        event: noMatch || toState = "./"

    state: Hello
        intent!: /hello
        a: YOOOOY MAN 
        go!: /WhatsUp
    
    state: WhatsUp
        a: What's up?

    state: Bye
        intent!: /bye
        a: Bye bye

    state: NoMatch
        event!: noMatch
        a: I do not understand. You said: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}

    state: fine
        random: 
            a: I'm fine, thank you