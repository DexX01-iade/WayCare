package pt.iade.ei.waycareapp.ui.screens.exif

class ExifScreen {
    @Composable
    fun ExifScreen(viewModel: ExifViewModel = viewModel()) {

        val context = LocalContext.current
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri ->
            uri?.let {
                viewModel.enviarImagem(it, context)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(onClick = { launcher.launch("image/*") }) {
                Text("Escolher imagem")
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (viewModel.isLoading)
                CircularProgressIndicator()

            viewModel.erro?.let {
                Text("Erro: $it", color = Color.Red)
            }

            viewModel.latitude?.let {
                Text("Latitude: $it")
            }

            viewModel.longitude?.let {
                Text("Longitude: $it")
            }

            viewModel.data?.let {
                Text("Data EXIF: $it")
            }
        }
    }

}