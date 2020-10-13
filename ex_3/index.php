<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <title>Date</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
    <div>
      <!-- Nhập thông tin -->
        <div class="container">
            <h2 class = "text-center">Điền thông tin </h2>
           
            <form action="<?php echo $_SERVER["PHP_SELF"];?>" method = "POST">
                <div class="form-group d-flex">
                    <label for="email">Tên của bạn</label>
                    <input type="text" class="form-control" placeholder="Nhập tên" name="name">
                </div>
                <div class="form-group">
                    <label for="date">Ngày :</label>
                    <!-- Đưa các giá trị ngày tháng năm  -->
                    <select name="date">
                        <?php                   
                                for($i = 1; $i <= 31; $i ++) {
                                    print("<option>$i</option>");
                                }                               
                        ?>
                    </select>
                    </select>
                    <select name="month">
                        <?php
                            for($i = 1; $i <= 12; $i ++) {
                                print("<option>$i</option>");
                            }       
                        ?>
                    </select>
                    <select name="year">
                        <?php
                           for($i = 1800; $i < 2020; $i ++) {
                                print("<option>$i</option>");
                           }     
                        ?>
                    </select>
                </div>

                <div class="form-group">
                    <label for="hour">Thời gian :</label>
                    <select name = "hour">
                        <?php
                                
                                for($i = 0; $i <= 23; $i ++) {
                                    print("<option>$i</option>");
                                }  
                                
                        ?>
                    </select>
                    <select name="minutes">
                        <?php
                            for($i = 0; $i <= 59; $i ++) {
                                print("<option>$i</option>");
                            }       
                        ?>
                    </select>
                    <select name="seconds" >
                        <?php
                           for($i = 0; $i < 59; $i ++) {
                                print("<option>$i</option>");
                           }     
                        ?>
                    </select>
                </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                    <button type="submit" class="btn btn-default">Reset</button></br>
                    
            </form>
            <!-- Hiển thị thông tin -->
            <div>
                <?php
                    if($_SERVER["REQUEST_METHOD"] == "POST") {
                        $name = $_POST["name"];
                        
                        $month = $_POST["month"];
                        $year = $_POST["year"];
                        $hour = $_POST["hour"];
                        $minutes = $_POST["minutes"];
                      
                        if(isset($_POST["date"])){
                            $date = $_POST["date"];
                        }else {
                            $date = null;
                        }
                        if(isset($_POST["seconds"])){
                            $seconds= $_POST["seconds"];
                        }else {
                            $seconds= null;
                        }
                            // Xử lí khi chưa nhập tên
                            if (empty($name)) {
                                echo "<span class='profile-content'>Bạn chưa điền tên!</span><br/>";
                            } else {
                                echo "<label class='profile-label'><b>Xin chào,&nbsp</b>&nbsp;</label>";
                                echo "<span class='proflie-content'>" . $name . "</span><br/></br>";
                            // Xử lí dữ liệu năm nhuận
                            if($year % 400 == 0 ||($year % 100 != 0 && $year % 4 == 0) ) {
                                if($month == 2 && $date > 29) {
                                    echo "<span class='proflie-content'>Đây là năm nhuận, vui lòng chọn lại ngày</span><br/></br>";
                                }else {
                                    switch($month) {
                                        case 4:
                                        case 6:
                                        case 9:
                                        case 11:
                                            if($date == 31) {
                                                echo"<span>Chọn quá số ngày trong tháng, vui lòng nhập lại </span>";
                                            } else {
                                                echo "<span class='proflie-content'>Bạn có cuộc hẹn lúc </span>";
                                                echo $hour .":". $minutes. ":". $seconds. ",&nbsp". $date. "/". $month. "/". $year. "</br></br>";
                                            }
                                            break;
                                        default: 
                                            echo "<span class='proflie-content'>Bạn có cuộc hẹn lúc </span>";
                                            echo $hour .":". $minutes. ":". $seconds. ",&nbsp". $date. "/". $month. "/". $year. "</br></br>";
                                            break;
                                    }
                                    if($hour > 12) {
                                        $hour = $hour - 12;
                                        echo "<span>Theo khung 12h, ngày và tháng bạn hẹn là:&nbsp</span>". $hour .":". $minutes. ":". $seconds. "PM,&nbsp". $date. "/". $month. "/". $year. "</br></br>";
                                    }else {
                                        echo "<span>Theo khung 12h, ngày và tháng bạn hẹn là: &nbsp</span>". $hour .":". $minutes. ":". $seconds. "AM,&nbsp". $date. "/". $month. "/". $year. "</br></br>";
                                    }
                                    switch($month) {
                                        case 4:
                                        case 6:
                                        case 9:
                                        case 11:
                                            echo "<span>Tháng có 30 ngày</span>";
                                            break;
                                        case 1:
                                        case 3:
                                        case 5: 
                                        case 7:
                                        case 8:
                                        case 10:
                                        case 12:
                                            echo "<span>Tháng có 31 ngày</span>";
                                            break;
                                        case 2: 
                                            if($year % 400 == 0 ||($year % 100 != 0 && $year % 4 == 0) ) {
                                                echo "<span>Tháng có 28 ngày</span>";
                                                break;
                                            } else {
                                                echo "<span>Tháng có 29 ngày</span>";
                                                break;
                                            }
                                    }
                                }
                            }
                        }
                    }
                ?>               
            </div>
        </div>
    </div>

</body>
</html>