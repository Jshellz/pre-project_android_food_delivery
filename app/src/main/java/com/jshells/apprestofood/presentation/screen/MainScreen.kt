package com.jshells.apprestofood.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.util.rangeTo
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jshells.apprestofood.R
import com.jshells.apprestofood.domain.model.DishModel
import com.jshells.apprestofood.presentation.FoodCategory
import com.jshells.apprestofood.presentation.theme.colors.Gray300

@Composable
fun MainScreen() {
    Main()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {

    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(FoodCategory.ALL) }

    val dishes = remember {
        listOf(
            DishModel(1, "Бургер Классический", "Сочная говядина с овощами", "350 ₽", FoodCategory.COMBO),
            DishModel(2, "Цезарь Ролл", "Курица, салат, соус цезарь", "290 ₽", FoodCategory.COMBO),
            DishModel(3, "Сырный соус", "Нежный сливочный соус с сыром", "90 ₽", FoodCategory.SAUCES),
            DishModel(4, "Том Ям", "Острый тайский суп с креветками", "420 ₽", FoodCategory.SOUPS),
            DishModel(5, "Чизкейк", "Классический нью-йоркский чизкейк", "210 ₽", FoodCategory.DESSERTS),
            DishModel(6, "Кола", "Освежающий напиток 0.5л", "120 ₽", FoodCategory.DRINKS),
            DishModel(7, "Двойной бургер", "Две котлеты, двойной сыр", "450 ₽", FoodCategory.COMBO),
            DishModel(8, "Кетчуп", "Томатный соус", "50 ₽", FoodCategory.SAUCES),
        )
    }

    val filterDishes = dishes.filter { dish ->
        (selectedCategory == FoodCategory.ALL || dish.category == selectedCategory) &&
                (searchQuery.isEmpty() || dish.name.contains(searchQuery, ignoreCase = true))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = stringResource(R.string.name_app),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(
                            onClick = {},
                        ) {
                            Image(
                                painter = painterResource(R.drawable.test_profile),
                                contentDescription = "profile",
                                modifier = Modifier
                                    .size(32.dp)
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            NavController()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                SearchSection(
                    searchQuery = searchQuery,
                    onSearchQueryChanged = { searchQuery = it}
                )
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                CategoriesSection(
                    selectedCategory,
                    onCategorySelected = { selectedCategory = it}
                )
            }
            item {
                Text(
                    text =
                        if (selectedCategory == FoodCategory.ALL) "All Dishes"
                        else selectedCategory.title,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            if (filterDishes.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Dish is not found",
                            fontSize = 18.sp,
                            color = Color.Gray
                        )
                    }
                }
            } else {
                items(filterDishes) { dish ->
                    DishCard(dish = dish)
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }

}

@Composable
fun SearchSection(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChanged,
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(
                        text = "Search dishes",
                        style = TextStyle.Default.copy(Color.Red),
                    )
                },
                leadingIcon = {
                    Icon(
                        painterResource(R.drawable.search),
                        contentDescription = "search",
                        modifier = Modifier
                            .size(25.dp)
                    )
                },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors()
            )
        }

        FilterButton()
    }
}

@Composable
fun FilterButton() {
    Card(
        modifier = Modifier
            .padding(top = 10.dp)
            .size(25.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Red
        ),
        onClick = {}
    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            Icon(
                imageVector = Icons.Default.FilterList,
                contentDescription = "Filters",
                tint = Color.White
            )
        }
    }
}

@Composable
fun CategoriesSection(
    sectionCategory: FoodCategory,
    onCategorySelected: (FoodCategory) -> Unit
) {
    val categories = FoodCategory.entries.toTypedArray()

    Column {
        Text(
            text = "Category",
            modifier = Modifier
                .padding(horizontal = 16.dp),
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(9.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) { category ->
                CategoryChip(
                    category = category,
                    isSelected = sectionCategory == category,
                    onClick = { onCategorySelected(category)}
                )
            }
        }
    }
}

@Composable
fun CategoryChip(
    category: FoodCategory,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = { Text(category.title) },
        modifier = Modifier
            .padding(vertical = 4.dp)
    )
}

@Composable
fun DishCard(
    dish: DishModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // mock Image
            Box(modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape((8.dp)))
                .background(Gray300),
                contentAlignment = Alignment.Center)
            {
                Text(
                    text = dish.category.title.take(3),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = dish.name,
                    fontSize = 18.sp,
                    color = Color.Black,
                    maxLines = 2
                )
                Text(
                    text = dish.description,
                    fontSize = 18.sp,
                    color = Color.Black,
                    maxLines = 2
                )
                Text(
                    text = dish.price,
                    fontSize = 18.sp,
                    color = Color.Black,
                    maxLines = 2
                )
            }
            OutlinedButton(
                onClick = {},
                colors = ButtonColors(containerColor = Color.Red, contentColor = Color.White,
                    disabledContentColor = Color.White, disabledContainerColor = Color.Red),
                shape = CircleShape
            ) {
                Text(
                    text = "Add",
                    fontSize = 15.sp,
                    style = TextStyle.Default.copy(Color.White)
                )
            }
        }
    }
}

@Composable
fun NavController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            NavController(navController)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainShowPreview() {
    MainScreen()
}