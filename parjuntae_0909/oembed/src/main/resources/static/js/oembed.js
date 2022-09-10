const getOembed = (input) => {
  const url = "/oembed/api?search=" + input;

  fetch(url)
    .then((res) => {
      res.json()
        .then((json) => {
          const contentTitle = document.getElementById("content-title");
          const contentList = document.getElementById("content-list");

          contentTitle.innerHTML = "";
          contentList.innerHTML = "";

          // 더 나은 방법은 json에 있는 데이터를 Map으로 저장하고
          // Map으로 받아서 해당 컬렉션 안에 있는 모든 데이터를 꺼내는게 더 효율적이라 생각한다
          // 다만, 예제에 나와있는 순서대로 정렬하고 싶어서 이 방법으로 하자!
          let titleData = "";
          if (json.title != null) {
            titleData =
              "<div><div>title</div><div>" + json.title + "</div></div>";
              contentTitle.innerHTML = <div>title</div>
          }

          let data = "";
          if (json.type != null)
            data += "<li>" + "<div>type</div><div>" + json.type + "</div></li>";
          if (json.version != null)
            data +=
              "<li>" + "<div>version</div><div>" + json.version + "</div></li>";
          if (json.provider_name != null)
            data +=
              "<li>" +
              "<div>provider_name</div><div>" +
              json.provider_name +
              "</div></li>";
          if (json.provider_url != null)
            data +=
              "<li>" +
              "<div>provider_url</div><div><a href='" +
              json.provider_url +
              "'>" +
              json.provider_url +
              "</a></div></li>";
          if (json.author_name != null)
            data +=
              "<li>" +
              "<div>author_name</div><div>" +
              json.author_name +
              "</div></li>";
          if (json.author_url != null)
            data +=
              "<li>" +
              "<div>author_url</div><div><a href='" +
              json.author_url +
              "'>" +
              json.author_url +
              "</a></div></li>";
          if (json.is_plus != null)
            data +=
              "<li>" + "<div>is_plus</div><div>" + json.is_plus + "</div></li>";
          if (json.html != null)
            data +=
              "<li>" +
              "<div>html<br/>(" +
              json.width +
              "/" +
              json.height +
              ")</div><div><xmp>" +
              json.html +
              "</xmp>" +
              json.html +
              "</div></li>";
          if (json.width != null)
            data +=
              "<li>" + "<div>width</div><div>" + json.width + "</div></li>";
          if (json.height != null)
            data +=
              "<li>" + "<div>height</div><div>" + json.height + "</div></li>";
          if (json.duration != null)
            data +=
              "<li>" + "<div>height</div><div>" + json.duration + "</div></li>";
          if (json.description != null)
            data +=
              "<li>" +
              "<div>height</div><div>" +
              json.description +
              "</div></li>";
          if (json.thumbnail_url != null)
            data +=
              "<li>" +
              "<div>thumbnail_url<br/>(" +
              json.thumbnail_width +
              "/" +
              json.thumbnail_height +
              ")</div><div><a href='" +
              json.thumbnail_url +
              "'>" +
              json.thumbnail_url +
              "</a><br/><br/><img src='" +
              json.thumbnail_url +
              "'/></div></li>";
          if (json.thumbnail_width != null)
            data +=
              "<li>" +
              "<div>thumbnail_width</div><div>" +
              json.thumbnail_width +
              "</div></li>";
          if (json.thumbnail_height != null)
            data +=
              "<li>" +
              "<div>thumbnail_height</div><div>" +
              json.thumbnail_height +
              "</div></li>";
          if (json.thumbnail_url_with_play_button != null)
            data +=
              "<li>" +
              "<div>thumbnail_url_with_play_button</div><div><a href='" +
              json.thumbnail_url_with_play_button +
              "'>" +
              json.thumbnail_url_with_play_button +
              "</a></div></li>";
          if (json.upload_data != null)
            data +=
              "<li>" +
              "<div>upload_data</div><div>" +
              json.upload_data +
              "</div></li>";
          if (json.video_id != null)
            data +=
              "<li>" +
              "<div>video_id</div><div>" +
              json.video_id +
              "</div></li>";
          if (json.uri != null)
            data += "<li>" + "<div>uri</div><div>" + json.uri + "</div></li>";
          if (json.cache_age != null)
            data +=
              "<li>" +
              "<div>cache_age</div><div>" +
              json.cache_age +
              "</div></li>";

          render.innerHTML = data;
          console.log(json);
        })
        .catch((err) => {
          alert("유요하지 않은 주소입니다.");
          console.log(err);
        });
    })
    .catch((err) => {
      alert("유요하지 않은 주소입니다.");
      console.log(err);
    });
  // .then((data) => {
  //   console.log(data);
  //   console.log(`jssss = ${JSON.stringify(data.response)}`);
  //   console.log(`jtttt = ${data.response}`);

  //   // let titleArea = document.getElementById("titleArea");
  //   // let ulArea = document.getElementById("ulArea");
  //   // titleArea.innerHTML = "";
  //   // ulArea.innerHTML = "";
  //   // let dataList = "";
  //   // dataList += "<li><div>type</div><div>제이슨타입</div></li>";
  //   // dataList += "<li><div>type</div><div>제이슨타입</div></li>";
  //   // dataList += "<li><div>type</div><div>제이슨타입</div></li>";
  //   // dataList += "<li><div>type</div><div>제이슨타입</div></li>";
  //   // titleArea.innerHTML = "<div>title</div><div>제목</div>";
  //   // ulArea.innerHTML = dataList;
  // })
  // .catch((err) => {
  //   alert(`잘못 입력 하셨습니다. ${err}`);
  // });
};
