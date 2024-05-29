const settingChange = document.querySelectorAll('.setting-Change');
const settingInfoArr = document.querySelectorAll('.setting-info>div');
const infoChange = settingChange[0];
infoChange.addEventListener('click', function() {
	const formName = document.createElement('form');
	const formIntroduce = document.createElement('form');

	formName.method = 'post';
	formName.action = '';

	const inputName = document.createElement('input');
	const inputIntroduce = document.createElement('input');
	const submit = document.createElement('input');

	inputName.type = 'text';
	inputName.name = 'myNameInput';
	inputName.className = 'myNameInput';
	inputName.value = settingInfoArr[0].textContent;

	inputIntroduce.type = 'text';
	inputIntroduce.name = 'myNameInput';
	inputIntroduce.className = 'myIntroduceInput';
	inputIntroduce.value = settingInfoArr[1].textContent;

	submit.type = 'submit';
	submit.className = 'settingChangeSubmit';
	submit.value = '저장';

	formName.appendChild(inputName);
	formIntroduce.appendChild(inputIntroduce);

	settingInfoArr[0].innerHTML = '';
	settingInfoArr[1].innerHTML = '';
	infoChange.innerHTML = '';

	settingInfoArr[0].appendChild(formName);
	settingInfoArr[1].appendChild(formIntroduce);
	settingInfoArr[2].appendChild(submit);
})

const socialChange = settingChange[1];
const settingSocial = document.querySelector('.setting-social');

socialChange.addEventListener('click', function(){
	socialChange.innerHTML = '';

	const socialDiv = document.createElement('div');
	socialDiv.className = 'social';

	const socialForm = document.createElement('form');
	socialForm.method = 'post';
	socialForm.action = '';

	const inputEmail = document.createElement('input');
	inputEmail.type = 'text';
	inputEmail.name = 'inputEmail';
	inputEmail.className = 'inputSocial';
	inputEmail.placeholder ='e-mail을 입력하세요';

	const inputgit = document.createElement('input');
	inputgit.type = 'text';
	inputgit.name = 'inputGit';
	inputgit.className = 'inputSocial';
	inputgit.placeholder ='Github 계정을 입력하세요';

	const inputHome = document.createElement('input');
	inputHome.type = 'text';
	inputHome.name = 'inputHome';
	inputHome.className = 'inputSocial';
	inputHome.placeholder ='홈페이지 주소를 입력하세요';
	
	const inputSubmit = document.createElement('input');
	inputSubmit.type = 'submit';
	inputSubmit.className = 'settingChangeSubmit';
	inputSubmit.value = '저장';

	socialDiv.appendChild(inputEmail);
	socialDiv.appendChild(inputgit);
	socialDiv.appendChild(inputHome);
	socialDiv.appendChild(inputSubmit);
	socialForm.appendChild(socialDiv);
	settingSocial.replaceChild(socialForm, socialChange);
})