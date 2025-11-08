package pt.iade.ei.waycareapp.data.preview

import pt.iade.ei.waycareapp.data.model.TipoAnomalia
import pt.iade.ei.waycareapp.data.model.Localizacao
import pt.iade.ei.waycareapp.data.model.Anomalia
import pt.iade.ei.waycareapp.data.model.Reporte
import pt.iade.ei.waycareapp.data.model.Utilizador
import java.time.LocalDateTime

val mockReportes = listOf(
    Reporte(
        id = 1,
        utilizador = Utilizador(1, "Maria", "maria@email.com", "1234", "912345678"),
        obstaculo = Anomalia(
            id = 1,
            categoria = TipoAnomalia(1, "Rampa Inexistente", "Não há rampa de acesso"),
            descricao = "Sem rampa na entrada",
            grauPerigo = "Médio"
        ),
        localizacao = Localizacao(1, 38.717, -9.139, "Rua A"),
        data = LocalDateTime.now().toString(),
        estado = "Pendente",
        comentario = "Muito difícil para cadeiras de rodas"
    )
)
