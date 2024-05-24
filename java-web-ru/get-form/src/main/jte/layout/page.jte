@import gg.jte.Content
@param Content content

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        body {
            background: linear-gradient(45deg, #4158d0 0%, #c850c0 40%, #ffcc70 90%);
            font-family: Arial, sans-serif;
            color: white;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            background-color: rgba(0, 0, 0, 0.5);
        }
        .navbar a {
            color: white;
            text-decoration: none;
            font-size: 1.2em;
        }
        .navbar a:hover {
            text-decoration: underline;
        }
        .content {
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            margin-top: 20px;
        }
        h1 {
            font-size: 3em;
            margin-bottom: 20px;
        }
        .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.2);
            border-radius: 10px;
        }
        .list-group-item {
            background-color: rgba(255, 255, 255, 0.2);
            border: none;
        }
    </style>
</head>
    <body>
        <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${content}</h1>
        </main>
        </div>
    </body>
</html>
