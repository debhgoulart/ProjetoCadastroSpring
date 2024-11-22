const formulario =  document.getElementById('register-form')

formulario.addEventListener('submit', function(event) {
    console.log('teste1')
    event.preventDefault();
    console.log('teste2')
    enviar();
});

function enviar() {
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const telefone = document.getElementById('telefone').value;
    const logradouro = document.getElementById('logradouro').value;
    const numero = document.getElementById('numero').value;
    const complemento = document.getElementById('complemento').value;
    const bairro = document.getElementById('bairro').value;
    const cidade = document.getElementById('cidade').value;
    const uf = document.getElementById('uf').value;
    const cep = document.getElementById('cep').value;
    const senha = document.getElementById('senha').value;

    const dados = {
        nome: nome,
        email: email,
        telefone: telefone,
        logradouro: logradouro,
        numero: numero,
        complemento: complemento,
        bairro: bairro,
        cidade: cidade,
        uf: uf,
        cep: cep,
        senha: senha
    };

    fetch('http://localhost:8080/cadastro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
    .then(response => response.json())
    .then(data => {
        console.log('SUCESSO', data);
        alert('Usuário cadastrado');
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao enviar formulário');
    });
}