
INSERT INTO logistica.item(
   ite_id, ite_descricao, ite_quantidade)
VALUES (995,'Produdo A', 2);

INSERT INTO logistica.item(
    ite_id, ite_descricao, ite_quantidade)
VALUES (996,'Produdo B', 2);


INSERT INTO logistica.item(
    ite_id, ite_descricao, ite_quantidade)
VALUES (997,'Produdo C', 2);

INSERT INTO logistica.item(
    ite_id, ite_descricao, ite_quantidade)
VALUES (998,'Produdo D', 2);

INSERT INTO logistica.pedido(
    ped_id, ped_data_entrada, ped_destino, ped_status, ped_cpf_cliente)
VALUES (995,current_date, 'teste', 'PRONTO', '00522240313');

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (995, 995);


INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (995, 996);

INSERT INTO logistica.pedido(
   ped_id, ped_data_entrada, ped_destino, ped_status, ped_cpf_cliente)
VALUES (996,current_date, 'teste', 'PRONTO', '00522240313');

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (996, 997);

INSERT INTO logistica.pedido_item(
    pedido_id, ite_id)
VALUES (996, 998);
