$(document).ready(function() {
    var $inputTitle = $('#inputTitle');
    var $inputText = $('#inputText');

    var $outputTitle = $('#outputTitle');
    var $outputText = $('#outputText');

    $inputTitle.on('input', function() {
        $outputTitle.text($inputTitle.val());
    });

    $inputText.on('input', function() {
        $outputText.text($inputText.val());
    });
});
