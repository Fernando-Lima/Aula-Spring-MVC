$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
    var button = $(event.relatedTarget);
    var codigo = button.data('codigo');
    var descricao = button.data('descricao');
    var nomeDaView = button.data('nomeview');
    var modal = $(this);
    var form = modal.find('form');
    var action = form.data('url-base');
    if (!action.endsWith('/')) {
        action += '/';
    }
    form.attr('action', action + nomeDaView +'/' +codigo);
    modal.find('.modal-body span').html('Tem certeza que deseja excluir o '+nomeDaView+' <strong>' + descricao + '</strong>?');
});
$(function() {
    $('[rel="tooltip"]').tooltip();
    $('.js-currency').maskMoney({
        decimal: ',',
        thousands: '.'
    });
    $('.js-atualizar-status').on('click', function(event) {
        event.preventDefault();
        var botaoReceber = $(event.currentTarget);
        var urlReceber = botaoReceber.attr('href');
        var response = $.ajax({
            url: urlReceber,
            type: 'PUT'
        });
        response.done(function(e) {
            var codigo = botaoReceber.data('codigo');
            $('[data-role=' + codigo + ']').html('<span class="label label-success">' + e + '</span>');
            botaoReceber.hide();
        });
        response.fail(function(e) {
            console.log(e);
            alert('Erro recebendo cobrança');
        });
    });
});