document.getElementById('inputTitle').addEventListener('input', function() {
	document.getElementById('outputTitle').innerText = this.value;
});

document.getElementById('inputText').addEventListener('input', function() {
	document.getElementById('outputText').innerText = this.value;
});