-- =====================================
-- SEED DE PACIENTES
-- =====================================

INSERT INTO PACIENTES (nome, email, data_nascimento) VALUES
    ('João Silva', 'joao.silva@example.com', '1990-03-10'),
    ('Maria Souza', 'maria.souza@example.com', '1985-07-01'),
    ('Carlos Pereira', 'carlos.pereira@example.com', '1992-11-22'),
    ('Ana Lima', 'ana.lima@example.com', '1998-04-15'),
    ('Lucas Andrade', 'lucas.andrade@example.com', '1995-09-09');

-- =====================================
-- SEED DE REGISTROS DIÁRIOS
-- =====================================

INSERT INTO REGISTROS_DIARIOS (paciente_id, data_registro, nivel_humor, observacoes) VALUES
    (1, '2025-01-01', 4, 'Dia produtivo, dormiu bem.'),
    (1, '2025-01-02', 3, 'Um pouco cansado, mas estável.'),
    (1, '2025-01-03', 5, 'Ótima noite de sono.'),

    (2, '2025-01-01', 2, 'Crise de ansiedade pela manhã.'),
    (2, '2025-01-03', 5, 'Fez caminhada e melhorou muito.'),
    (2, '2025-01-04', 1, 'Picos de ansiedade no trabalho.'),

    (3, '2025-01-01', 1, 'Dia muito difícil, estresse elevado.'),
    (3, '2025-01-02', 2, 'Ainda cansado, mas um pouco melhor.'),
    (3, '2025-01-04', 3, 'Sessão de terapia ajudou.'),

    (4, '2025-01-01', 5, 'Excelente humor, meditou pela manhã.'),
    (4, '2025-01-02', 4, 'Dia estável e tranquilo.'),
    (4, '2025-01-03', 4, 'Fez yoga e manteve bem-estar.'),

    (5, '2025-01-01', 3, 'Rotina normal.'),
    (5, '2025-01-02', 2, 'Pouco sono, irritado.'),
    (5, '2025-01-03', 4, 'Dormiu melhor, disposição aumentou.');