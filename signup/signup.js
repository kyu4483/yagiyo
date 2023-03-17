{
  const $idInput = document.getElementById('id');
  $idInput.addEventListener('focus', () => {
    $idInput.placeholder = '';
  });
  $idInput.addEventListener('blur', () => {
    $idInput.placeholer = '영문,숫자를 이용해 만들어주세요(15자내외)';
  });
}

{
  const $pwInput = document.getElementById('pw');
  $pwInput.addEventListener('focus', () => {
    $pwInput.placeholder = '';
  });
  $pwInput.addEventListener('blur', () => {
    $pwInput.placeholer =
      '대소문자구분 영문자, 숫자조합으로 적어주세요 (8~20자)';
  });
}

{
  const $nickInput = document.getElementById('nick');
  $nickInput.addEventListener('focus', () => {
    $nickInput.placeholder = '';
  });
  $nickInput.addEventListener('blur', () => {
    $nickInput.placeholer =
      '영문자, 숫자, 한글조합으로 적어주세요 (10글자내외)';
  });
}
