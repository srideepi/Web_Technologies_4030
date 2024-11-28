<?php
include 'connect.php';
?>
<!DOCTYPE html>
<html>
<head>
    <title>Floral Theme</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>


    <main>
        <h1>Welcome to the Floral Shop</h1>
        <p>Our collection:</p>
        <ul>
        <?php
        $sql = "SELECT name, color, price FROM flowers";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                echo "<li>" . $row["name"] . " (" . $row["color"] . ") - $" . $row["price"] . "</li>";
            }
        } else {
            echo "No flowers available.";
        }
        ?>
        </ul>
    </main>

   
</body>
</html>
