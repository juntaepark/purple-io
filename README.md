oEmbed 데이터 수집 서비스 만들기

하단의 요구사항을 읽고 실제로 동작하는 서버코드를 작성해주세요.

### **요구사항**

youtube, instagram, twitter, vimeo등의 컨텐츠를 미리보여주는 사이트를 만드려고합니다.

URL을 입력받고 [oEmbed](http://oembed.com/) 데이터를 수집하여 보여주는 서비스입니다.

테스트 URL 리스트

- [https://www.youtube.com/watch?v=dBD54EZIrZo](https://www.youtube.com/watch?v=dBD54EZIrZo)
- [https://www.instagram.com/p/BUawPlPF_Rx/](https://www.instagram.com/p/BUawPlPF_Rx/)
- [https://twitter.com/hellopolicy/status/867177144815804416](https://twitter.com/hellopolicy/status/867177144815804416)
- [https://vimeo.com/20097015](https://vimeo.com/20097015)

### **주의사항**

- 브라우저에서 해당 서비스로 바로 요청하는 방법이 아닌 백엔드 서버를 거쳐서 요청해야 합니다.
    - Browser -> Backend -> youtube, instagram, ...
- 언어와 프레임워크는 자유롭게 선택해주세요.
- instagram oEmbed 기능을 사용할 수 없다면 사용할 수 없는 이유를 적어주세요.

### **참고 사이트**

- [http://oembed.com/](http://oembed.com/)

### 결과 샘플

- URL을 입력받는 폼을 만들고 확인 버튼을 누르면 해당 URL에 대한 oembed 정보를 출력하고 html값과 thumbnail_url은 미리보기로 보여줍니다.

![https://github.com/purpleworks/coding_test/raw/master/Backend/oembed.png](https://github.com/purpleworks/coding_test/raw/master/Backend/oembed.png)
