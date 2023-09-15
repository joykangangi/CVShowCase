package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.R

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    input: String,
    onInputChange: (String) -> Unit,
    txtLabel: String,
) {
    Column(
        modifier = modifier,
        content = {
            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                value = input,
                onValueChange = onInputChange,
                textStyle = MaterialTheme.typography.bodyLarge,
                label = { Text(text = txtLabel, style = MaterialTheme.typography.titleSmall) },
            )
            Spacer(modifier = modifier.height(5.dp))

            if (input.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.input_err),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    )
}