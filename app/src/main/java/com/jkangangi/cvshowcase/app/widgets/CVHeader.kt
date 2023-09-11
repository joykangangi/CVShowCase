package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.R


private const val EXPAND_ANIMATION_DURATION = 500

@Composable
fun CVHeader(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    header: String,
    body: @Composable ColumnScope.() -> Unit
) {

    var isExpanded by remember { mutableStateOf(true) }
    val transition = updateTransition(targetState = isExpanded, label = "")

    val onArrowClick = remember {
        {
            isExpanded = !isExpanded
        }
    }

    val bodyCardModifiers = modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = onArrowClick,
        )
        .padding(start = 12.dp, end = 12.dp)

    val arrowRotation: Float by transition.animateFloat(
        transitionSpec = { tween(durationMillis = EXPAND_ANIMATION_DURATION) },
        label = "arrowTransition",
        targetValueByState = { if (it) 180f else 0f } //if true 180f else 0f
    )


    Column(
        content = {
            ElevatedCard(
                modifier = modifier.padding(5.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                content = {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Icon(
                                imageVector = icon,
                                contentDescription = stringResource(id = R.string.cv_icon)
                            )
                            Spacer(modifier = modifier.width(4.dp))
                            Text(text = header, style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = modifier.weight(1f))
                            IconButton(
                                onClick = onArrowClick,
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = stringResource(id = R.string.close_icon),
                                        modifier = modifier.rotate(arrowRotation)
                                    )
                                })
                        }
                    )
                },
            )
            if (isExpanded) {
                ElevatedCard(
                    modifier = bodyCardModifiers,
                    content = body
                )
            }
        }
    )
}