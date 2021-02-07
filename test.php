<!DOCTYPE html>
<html>
<body>

<h1>My first PHP page</h1>

<?php
echo "Hello World!<br>";

function connect(){
	return mysqli("localhost","")
}
// function inches_to_feet($inches) {
// 	if($inches < 12)
// 		return 0;
// 	else
// 		return $inches / 12;
// }
if (isset($_GET['username'])) {
	echo $_GET['username']." ".$_GET['date_of_birth'];
}
?>

</body>
</html>