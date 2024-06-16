# OAuth2.0이란 무엇인가?

OAuth는 표준이다. 무엇에 대한 표준이냐. Open Authorization의 약자로써, 온라인 권한 처리의 표준이다.이것은 또한 하나의 프로토콜이라고 이해하면 된다. 이 프로토콜에서는 특정 절차를 정의하고, 권한을 부여한다. 그 절차와 권한이란, third-party 어플리케이션이 사용자의 리소스에 접근하기 위한 절차와 서비스 제공자의 api를 이용할 수 있는 권한을 부여한다. 대표적으로는 네이버 로그인, 구글 로그인과 같은 기능이 있다.
이 oauth2.0을 이용해서 다른 third-party 어플리케이션이 우리가 만든 어플리케이션의 사용자의 리소스에 접근할 수 있다.
예를 들어, 트레바리에 연동되는 외부 어플리케이션에서 트레바리에서 제공하는 기능을 사용할 수 있게 해주는 것이다. 이를테면 유저의 독서모임 참여 횟수라던지, 독서모임 일정과 같은 정보를 제공해주는 것이다.

# OAuth2.0의 개념을 구성하는 4가지

- 리소스 소유자(Resource Owner) : 웹 서비스를 이용하려는 유저, 자원(개인정보)을 소유하는 자, 사용자
- 클라이언트(Client) : OAuth2.0을 사용해서, 리소스에 접근하려고 시도하는 third-party 대상을 클라이언트라고 부른다 / 자사 또는 개인이 만드려고 하는 서버이다. 클라이언트라는 이름은 client가 resource server에 필요한 자원을 요청하는 관계이기 때문이다.
- 권한 서버(Authorization Server) : 클라이언트가 리소스에 대한 권한을 얻을 수 있돌록 도와주는 서버이다. 이 서버는 사용자 인증, 권한 부여 및 토큰 발급의 동작을 관리한다.
- 리소스 서버(Resource Server) : 리소스 서버는 보호되고 있는 리소스를 호스팅 하는 서버이다. 클라이언트의 엑세스를 허용하거나 거부하는 역할을 한다. 이 서버는 OAuth2.0에서 발급된 토큰을 사용하여 클라이언트에게 리소스에 엑세스할 권한을 부여하고 실제 데이터를 제공하는 역할을 한다. / 사용자의 개인정보를 가지고 있는 서버이다.

# OAuth2.0의 핵심 용어

- 액세스 토큰 : 리소스에 접근하기 위한 권한을 부여받는 토큰이다. 액세스 토큰은 권한 서버로부터 발급되며, 일반적으로는 제한된 유효기간을 가지고 있다.
- 리프레시 토큰 : 리프레시 토큰은 액세스 토큰이 만료되었을 경우, 새로운 액세스 토큰을 발급받기 위한 토큰이다.
- 범위(Scope) : 클라이언트가 리소스에 대해 어떤 작업을 수행할 수 있는지를 정의한 문자열이다. 범위는 권한 서버에 의해서 정의된다.
- 인증 코드(Authorization Code) : 인증 코드는 클라이언트가 액세스 토큰을 얻기 위한 중간 단계로 사용되는 코드이다.

# OAuth2.0의 기본적인 흐름 :
![스크린샷 2024-05-16 오후 8.37.23.png](..%2F..%2F..%2F..%2Fvar%2Ffolders%2F9v%2F2v83_q1d1kjf9t587n8xll200000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_T6WyCF%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-05-16%20%EC%98%A4%ED%9B%84%208.37.23.png)

- client(개인 서비스)는 resource owner(사용자)를 대신해서 로그인을 한다.
    - 이때, 필요한 정보를 resource server에서 얻은 후, 유효성을 판단한다.
    - client(개인 서비스)가 사용자를 대신해서, resource server에게 요청해 로그인을 대신하는 것이다.
- 위의 동작을 위해서 client(개인 서비스)는 다음의 과정을 거친다.
    - 1. resource owner로부터 동의를 얻는다 / 2.resource server로 부터 client의 신원을 확인한다.
    - 위와 같이해야하는 이유 :
        - resource owner 입장 : 자신의 정보를 제공하기 전에, client가 신뢰할 수 있는지 확인해야 한다. / client는 resource owner의 동의를 구해야한다.
        - resource server 입장 : client의 신원을 파악해야 한다. 이전에 인증해주었던 그 client가 맞을까? 지금 이 client가 resource owner의 일을 대신 수행해주려고 하는데, 괜찮은 것일까?를 확인해야한다. 이것을 위해서 resource server는 resource owner의 브라우저를 통해서 client를 구분하는 값(code)을 발급한다.




출처 :

[Understanding OAuth2.0](https://medium.com/web-security/understanding-oauth2-a50f29f0fbf7) <br/>
[OAuth2.0개념 및 연동](https://guide.ncloud-docs.com/docs/b2bpls-oauth2) <br/>
[OAuth 2.0 개념과 동작원리](https://hudi.blog/oauth-2.0/) <br/>
[OAuth 2.0 개념 - 그림으로 이해하기 쉽게 설명
출처: https://inpa.tistory.com/entry/WEB-📚-OAuth-20-개념-💯-정리 [Inpa Dev 👨‍💻:티스토리]](https://inpa.tistory.com/entry/WEB-%F0%9F%93%9A-OAuth-20-%EA%B0%9C%EB%85%90-%F0%9F%92%AF-%EC%A0%95%EB%A6%AC)

