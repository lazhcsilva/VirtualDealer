$("#form_cliente").validate({
	rules : {
		nome:{
			required:true,
			minlength:3
		},
		emailCliente:{
			required:true
		},
		cpf:{
			required:true
		},
		dataNascimento:{
			required:true
		},
		password:{
			required:true
		},
		telefone:{
			required:true
		}
	},
	messages:{
		nome:{
			required:"Por favor, informe seu nome",
			minlength:"O nome deve ter pelo menos 3 caracteres"
		},
		emailCliente:{
			required:"É necessário informar um email"
		},
		cpf:{
			required:"A mensagem não pode ficar em branco"
		},
		dataNascimento:{
			required:"Informe uma data de nascimento válida"
		},
		password:{
			required:"Digite uma senha válida"
		},
		telefone:{
			required:"Digite um telefone de contato"
		}
	}
});