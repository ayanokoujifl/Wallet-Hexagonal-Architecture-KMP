package com.luisleite.feature.wallet.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WalletScreen() {
    val viewModel = koinViewModel<WalletViewModel>()

    val state by viewModel.uiState.collectAsState()

    var userIdInput by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Minha Carteira KMP", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = userIdInput,
            onValueChange = { userIdInput = it },
            label = { Text("ID do Usuário") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.createWallet(userIdInput) },
            enabled = !state.isLoading
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text("Entrar / Criar")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Exibe o resultado ou erro
        when {
            state.error != null -> {
                Text(
                    text = "Erro: ${state.error}",
                    color = MaterialTheme.colorScheme.error
                )
            }

            state.wallet != null -> {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Carteira Encontrada!", style = MaterialTheme.typography.titleMedium)
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                        Text("ID: ${state.wallet?.id}")
                        Text("Saldo: R$ ${state.wallet?.balance}")
                        Text("Status: ${if (state.wallet?.active == true) "Ativa" else "Bloqueada"}")
                    }
                }
            }
        }
    }
}