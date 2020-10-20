<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="style1.css">
</head>

<body>
    <div class="container">
        <form action="" method="post" enctype="multipart/form-data">
            <?php
            error_reporting(E_ERROR);
            if (isset($_GET['Upload']) && isset($_GET['submit'])) {
                $number = $_GET['Upload'];
                $folder = $_GET['nameFolder'];
                // kiểm tra folder đã tồn tại hay chưa
                foreach (glob('../ex_4/*') as $file) {
                    if (basename($file) == $folder) {
                        echo "<span>Thư mục đã tồn tại</span></br>";
                        // quay lại trang trước
                        echo " <a href='javascript: history.go(-1)'>Trở lại</a>";
                    } else {
                        // tạo folder nếu chưa có
                        mkdir($folder);
                    }
                }
            }
            ?>
            <label for="fileUpload">Chọn file Upload</label>
            <input type="file" class=" form-control-file " name="fileUpload[]" id="fileUpload" value="" accept=".doc,.html, .docx,.pdf,.mp3,.wav,.png,.jpg,.xlsx,.txt,.json" multiple>
            <input type="submit" name="up" value="Upload" class="btn btn-primary"> </br>
        </form>
        <?php
        if (isset($_POST['up']) && isset($_FILES['fileUpload'])) {
            // lấy số file
            $countfiles = count($_FILES['fileUpload']['name']);
            //kiểm tra chọn đúng số file chưa
            if($countfiles != $_GET['Upload']) {
                echo "<p>Chọn sai số file</p>";
            } else {
                //up từng file
                for ($i = 0; $i < $countfiles; $i++) {
                    $target = 'upload/' . basename($_FILES['fileUpload']['name'][$i]);
                    if ($_FILES['fileUpload']['error'][$i] > 0)
                        echo "Upload lỗi rồi!";
                    else if (file_exists($target)) {   // Kiểm tra file tồn tại
                        echo "<p>file ".  basename($_FILES['fileUpload']['name'][$i]). " đã tồn tại</p>";
                    } else {
                        // Upload file
                        move_uploaded_file($_FILES['fileUpload']['tmp_name'][$i], 'upload/' . basename($_FILES['fileUpload']['name'][$i]));
                        echo "upload thành công file :  ";
                        echo $_FILES['fileUpload']['name'][$i] . "</br>";
                    }
                }
            }
            
        }
        ?>
        <!-- Trở lại trang trước -->
        <button class="btn btn-primary back" style="width: auto;margin-left: 300px"><a href='javascript: history.go(-1)' style="color: white; text-decoration:none;" >Trở lại</a></button>
    </div>

</body>

</html>