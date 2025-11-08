package pt.iade.ei.waycareapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import pt.iade.ei.waycareapp.data.model.Reporte
import android.util.Log

class ReporteViewModel : ViewModel() {

    // Metodo para guardar ou processar o reporte
    fun guardarReporte(reporte: Reporte) {
        // Aqui podes adicionar lógica para enviar para o backend via Retrofit
        // ou guardar localmente numa base de dados Room, etc.

        Log.d("ReporteViewModel", "Reporte recebido:")
        Log.d("ReporteViewModel", "Tipo: ${reporte.rep_ano_id.tip_id.tip_nome}")
        Log.d("ReporteViewModel", "Prioridade: ${reporte.rep_ano_id.ano_grau_perigo}")
        Log.d("ReporteViewModel", "Descrição: ${reporte.rep_descricao}")
        Log.d("ReporteViewModel", "Localização: ${reporte.rep_loc_id.loc_endereco}")
        Log.d("ReporteViewModel", "Imagem: ${reporte.fotografia.foto_url}")
    }
}
