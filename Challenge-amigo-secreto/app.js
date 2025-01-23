//O principal objetivo deste desafio é fortalecer suas habilidades em lógica de programação. Aqui você deverá desenvolver a lógica para resolver o problema.

// id amigo

const listaDeAmigos = [];

function adicionarAmigo() {
    let nome = document.querySelector('#amigo');
    let nomeAmigo = nome.value.trim();
    
    if (nomeAmigo === "") {
        alert('Por favor, insira um nome');
        return;
    }

    listaDeAmigos.push(nomeAmigo);
    nome.value = '';
    atualizarListaDeAmigos();
}

function atualizarListaDeAmigos() {
    let lista = document.querySelector('#listaAmigos');
    lista.innerHTML = '';

    for (let amigo of listaDeAmigos) {
        const item = document.createElement('li');
        item.textContent = amigo;
        lista.appendChild(item);
    };
}

function sortearAmigo() {
    if (listaDeAmigos.length === 0) {
        alert('Adicione amigos antes de iniciar o sorteio.')
        return;
    }

    const numeroSorteado = Math.floor(Math.random() * listaDeAmigos.length);
    const amigoEscolhido = listaDeAmigos[numeroSorteado];

    const mostrarResultado = document.querySelector('#resultado');
    const item = document.createElement('li');
    item.innerHTML = amigoEscolhido;
    mostrarResultado.appendChild(item);
}
