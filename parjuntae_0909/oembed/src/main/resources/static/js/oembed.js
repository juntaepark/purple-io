const getOembed = (input) => {
  const endpoint = "/oembed/api?search=" + input;

  fetch(endpoint)
    .then((response) => response.json())
    .then((data) => {
      const articleTitle = document.getElementById("title-data");
      const articleContent = document.getElementById("content-data");

      articleTitle.innerHTML = "";
      articleContent.innerHTML = "";

      let title = "";
      let content = "";

      Object.entries(data).map(([key, value]) => {
        if (key === "title") {
          title = "<div><div>" + key + "</div><div>" + value + "</div></div>";
          articleTitle.innerHTML = title;
        } else if (key === "provider_url" || key === "author_url") {
          content +=
            "<li><div>" +
            key +
            "</div><div><a href='" +
            value +
            "'>" +
            value +
            "</a></div></li>";
        } else if (key === "html") {
          content +=
            "<li><div>" +
            key +
            "<br/>(200/200)</div><div><xmp>" +
            value +
            "</xmp>" +
            value +
            "</div></li>";
        } else if (key === "thumbnail_url") {
          content +=
            "<li><div>" +
            key +
            "<br/>(200/200)</div><div><a href='" +
            value +
            "'>" +
            value +
            "</a><br/><br/><img src='" +
            value +
            "'/></div></li>";
        } else {
          content += "<li><div>" + key + "</div><div>" + value + "</div></li>";
        }

        articleContent.innerHTML = content;
      });
    });
};
