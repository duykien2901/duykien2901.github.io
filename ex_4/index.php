<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <form action="./upload.php" method="GET" enctype="multipart/form-data" >
            <div class="form-group">
                <label for="nameFolder">Folder Upload (nếu chưa có) </label></br>
                <input type="text" class="form-control" id="nameFolder" placeHolder="Chọn tên folder" name="nameFolder"></br>
            </div>
            <div class="form-group">
                <label for="fileName"> Chọn số file upload</label></br>
                <select name="Upload" id="filename" class="browser-default custom-select">
                    <?php
                    for ($i = 1; $i < 10; $i++) {
                        print "<option>$i</option>";
                    }
                    ?>
                </select>
            </div>

            </br>
            <div class="">
                <input type="submit" name="submit" value="Submit" class="btn btn-primary">
                <input type="reset" value="Reset" class="btn btn-primary">
            </div>
        </form>
    </div>
</body>

</html>